package com.desafio.banco.services;

import com.desafio.banco.dto.BankDTO;
import com.desafio.banco.entities.Bank;
import com.desafio.banco.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Transactional(readOnly = true)
    public List<BankDTO> findALL() {
        List<Bank> result = bankRepository.findAll();
        return result.stream().map(x -> new BankDTO(x)).toList();
    }
}
