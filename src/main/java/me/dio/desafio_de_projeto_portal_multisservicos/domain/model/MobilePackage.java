package me.dio.desafio_de_projeto_portal_multisservicos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "tb_mobile_package")
public class MobilePackage extends ServicePackage {

    @Column()
    private int dataLimit;
}
