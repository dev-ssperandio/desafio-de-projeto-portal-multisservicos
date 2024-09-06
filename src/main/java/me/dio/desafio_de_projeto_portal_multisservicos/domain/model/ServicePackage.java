package me.dio.desafio_de_projeto_portal_multisservicos.domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

@Entity(name = "tb_service_package")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MobilePackage.class, name = "mobile"),
        @JsonSubTypes.Type(value = TVPackage.class, name = "tv"),
        @JsonSubTypes.Type(value = BroadbandPackage.class, name = "broadband")
})
//@MappedSuperclass
public abstract class ServicePackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(precision = 13, scale = 2)
    private BigDecimal price;

    @Column
    private LocalDate limitDate = LocalDate.now(ZoneId.systemDefault()).plusDays(30);


    /*@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;*/

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(LocalDate limitDate) {
        this.limitDate = limitDate;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
