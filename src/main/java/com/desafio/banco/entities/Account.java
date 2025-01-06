package com.desafio.banco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Double value;
    private String imgUrl;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate instant;
    private AccountStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id") // chave estrangeira
    private User client;

    @ManyToMany
    @JoinTable(name = "tb_account_bank",
    joinColumns = @JoinColumn(name = "account_id"),
    inverseJoinColumns = @JoinColumn(name = "bank_id"))
    private Set<Bank> banks = new HashSet<>();

    public Account() {
    }

    public Account(Long id, String name, String type, Double value, String imgUrl, LocalDate instant, AccountStatus status, User client) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.imgUrl = imgUrl;
        this.instant = instant;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDate getInstant() {
        return instant;
    }

    public void setInstant(LocalDate instant) {
        this.instant = instant;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<Bank> getBanks() {
        return banks;
    }
}
