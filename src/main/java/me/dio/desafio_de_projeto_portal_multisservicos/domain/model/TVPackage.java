package me.dio.desafio_de_projeto_portal_multisservicos.domain.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_tv_package")
public class TVPackage extends ServicePackage {
    private int channelCount;
}
