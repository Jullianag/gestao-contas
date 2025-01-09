package com.desafio.banco.dto;

import com.desafio.banco.entities.Account;
import com.desafio.banco.entities.AccountStatus;
import com.desafio.banco.entities.Bank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AccountDTO {

    private Long id;

    @NotBlank(message = "Campo requerido!")
    @Size(min = 2, max = 10, message = "Apelido precisa ter de 2 a 10 caracteres!")
    private String nickname;
    private String types;
    private Double valor;
    private String imgUrl;
    private Instant instant;
    private AccountStatus status;

    @NotEmpty(message = "Não pode ser vazio")
    private List<BankDTO> banks = new ArrayList<>();

    public AccountDTO() {

    }

    public AccountDTO(Account entity) {
        id = entity.getId();
        nickname = entity.getNickname();
        types = entity.getTypse();
        valor = entity.getValor();
        imgUrl = entity.getImgUrl();
        instant = entity.getInstant();
        status = entity.getStatus();
        for(Bank bank : entity.getBanks()) {
            banks.add(new BankDTO(bank));
        }
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTypes() {
        return types;
    }

    public Double getValor() {
        return valor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Instant getInstant() {
        return instant;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public List<BankDTO> getBanks() {
        return banks;
    }
}
