package com.desafio.banco.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String types;
    private Double valor;
    private String imgUrl;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant instant;
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

    public Account(Long id, String nickname, String types, Double valor, String imgUrl, Instant instant, AccountStatus status, User client) {
        this.id = id;
        this.nickname = nickname;
        this.types = types;
        this.valor = valor;
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

    public String getNickname() {
        return nickname;
    }

    public void setName(String nickname) {
        this.nickname = nickname;
    }

    public String getTypse() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;
        return Objects.equals(getId(), account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
