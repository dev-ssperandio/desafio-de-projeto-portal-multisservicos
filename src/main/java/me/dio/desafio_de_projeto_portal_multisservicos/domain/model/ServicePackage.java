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
public abstract class ServicePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(precision = 13, scale = 2)
    private BigDecimal price;

    @Column
    private LocalDate contractDate; // = LocalDate.now(ZoneId.systemDefault()).plusDays(30);


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

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        LocalDate today = LocalDate.now();

        if (contractDate.isBefore(today)) {
            throw new IllegalArgumentException("A data de contrato do serviço não pode ser anterior à data atual.");
        }

        this.contractDate = contractDate.plusDays(30);
    }

}
