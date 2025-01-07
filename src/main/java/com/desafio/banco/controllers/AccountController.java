package com.desafio.banco.controllers;

import com.desafio.banco.dto.AccountDTO;
import com.desafio.banco.entities.Account;
import com.desafio.banco.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public Page<AccountDTO> findAll(Pageable pageable) {
        return accountService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public AccountDTO findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping
    public AccountDTO insert(@RequestBody AccountDTO dto) {
        return accountService.insert(dto);
    }
}
