package com.desafio.banco.services;

import com.desafio.banco.dto.AccountDTO;
import com.desafio.banco.entities.Account;
import com.desafio.banco.entities.AccountStatus;
import com.desafio.banco.repositories.AccountRepository;
import com.desafio.banco.services.exceptions.DatabaseException;
import com.desafio.banco.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Transactional(readOnly = true)
    public Page<AccountDTO> findAll(Pageable pageable) {
        Page<Account> result = accountRepository.findAll(pageable);
        return result.map(x -> new AccountDTO(x));
    }

    @Transactional(readOnly = true)
    public AccountDTO findById(Long id) {
        Account account = accountRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
        return new AccountDTO(account);
    }

    @Transactional
    public AccountDTO insert(AccountDTO dto) {
        Account entity = new Account();
        copyDtoToEntity(dto, entity);
        entity = accountRepository.save(entity);
        return new AccountDTO(entity);
    }

    @Transactional
    public AccountDTO update(Long id, AccountDTO dto) {
        try{
            Account entity = accountRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = accountRepository.save(entity);
            return new AccountDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
        try {
            accountRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial.");
        }
    }

    private void copyDtoToEntity(AccountDTO dto, Account entity) {
        entity.setNickname(dto.getNickname());
        entity.setTypes(dto.getTypes());
        entity.setValor(dto.getValor());
        entity.setImgUrl(dto.getImgUrl());
        entity.setInstant(Instant.now());
        entity.setStatus(AccountStatus.ACTIVE);
    }

}
