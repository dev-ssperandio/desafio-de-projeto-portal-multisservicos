package me.dio.desafio_de_projeto_portal_multisservicos.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "address_id")
    //@OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(/*mappedBy = "user",*/ cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<ServicePackage> packages;

    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<MobilePackage> mobilePackages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<TVPackage> tvPackages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BroadbandPackage> broadbandPackages;*/

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ServicePackage> getPackages() {
        return packages;
    }

    public void setPackages(List<ServicePackage> packages) {
        this.packages = packages;
    }

    /*public List<MobilePackage> getMobilePackages() {
        return mobilePackages;
    }

    public void setMobilePackages(List<MobilePackage> mobilePackages) {
        this.mobilePackages = mobilePackages;
    }

    public List<TVPackage> getTvPackages() {
        return tvPackages;
    }

    public void setTvPackages(List<TVPackage> tvPackages) {
        this.tvPackages = tvPackages;
    }

    public List<BroadbandPackage> getBroadbandPackages() {
        return broadbandPackages;
    }

    public void setBroadbandPackages(List<BroadbandPackage> broadbandPackages) {
        this.broadbandPackages = broadbandPackages;
    }*/
}
