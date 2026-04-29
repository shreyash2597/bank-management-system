package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private AccountRepository repository;

    // Create Account
    public String createAccount(Account account) {
        repository.save(account);
        return "Account Created Successfully";
    }

    // Deposit Money
    public String deposit(int accountNumber, double amount) {
        Account acc = repository.findById(accountNumber);

        if (acc != null) {
            acc.setBalance(acc.getBalance() + amount);
            return "Amount Deposited Successfully";
        }

        return "Account Not Found";
    }

    // Withdraw Money
    public String withdraw(int accountNumber, double amount) {
        Account acc = repository.findById(accountNumber);

        if (acc != null) {
            if (acc.getBalance() >= amount) {
                acc.setBalance(acc.getBalance() - amount);
                return "Withdrawal Successful";
            } else {
                return "Insufficient Balance";
            }
        }

        return "Account Not Found";
    }

    // Get Account Details
    public Account getAccount(int accountNumber) {
        return repository.findById(accountNumber);
    }
}