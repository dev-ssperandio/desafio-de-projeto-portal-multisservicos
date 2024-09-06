package me.dio.desafio_de_projeto_portal_multisservicos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "tb_tv_package")
public class TVPackage extends ServicePackage {

    @Column(nullable = false)
    private int channelCount;

    public int getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(int channelCount) {
        this.channelCount = channelCount;
    }
}
