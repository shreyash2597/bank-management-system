package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "*")
public class BankController {

    @Autowired
    private BankService service;

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable int id) {
        return service.getAccount(id);
    }
}