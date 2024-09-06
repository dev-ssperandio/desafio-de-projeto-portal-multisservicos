package me.dio.desafio_de_projeto_portal_multisservicos.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String  street;

    @Column(length = 6, nullable = false)
    private String number;

    @Column(length = 60, nullable = false)
    private String city;

    @Column(length = 20, nullable = false)
    private String state;

    @Column(length = 8, nullable = false)
    private String zipCode;

    /*@OneToMany(mappedBy = "address")
    private List<User> users;*/

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
