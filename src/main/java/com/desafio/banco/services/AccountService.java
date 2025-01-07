package com.desafio.banco.services;

import com.desafio.banco.dto.AccountDTO;
import com.desafio.banco.entities.Account;
import com.desafio.banco.entities.AccountStatus;
import com.desafio.banco.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

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
        Account account = accountRepository.findById(id).get();
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
        Account entity = accountRepository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = accountRepository.save(entity);
        return new AccountDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        accountRepository.deleteById(id);
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
