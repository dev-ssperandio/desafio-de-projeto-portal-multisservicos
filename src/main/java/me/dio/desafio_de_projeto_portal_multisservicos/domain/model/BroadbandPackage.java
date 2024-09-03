package me.dio.desafio_de_projeto_portal_multisservicos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity(name = "tb_broadband_package")
public class BroadbandPackage extends ServicePackage {

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal speed;
}
