package com.desafio.banco.dto;

import com.desafio.banco.entities.Bank;

public class BankDTO {

    private Long id;
    private String nome;

    public BankDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public BankDTO(Bank entity) {
        id = entity.getId();
        nome = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
