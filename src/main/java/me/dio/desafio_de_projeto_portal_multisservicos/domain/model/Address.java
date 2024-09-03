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

    @OneToMany(mappedBy = "address")
    private List<User> users;
}
