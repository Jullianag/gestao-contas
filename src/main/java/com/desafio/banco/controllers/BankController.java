package com.desafio.banco.controllers;

import com.desafio.banco.dto.BankDTO;
import com.desafio.banco.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public ResponseEntity<List<BankDTO>> findAll() {
        List<BankDTO> dtoList = bankService.findALL();
        return ResponseEntity.ok(dtoList);
    }
}
