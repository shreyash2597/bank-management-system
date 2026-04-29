package com.bank.repository;

import com.bank.model.Account;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    private Map<Integer, Account> accounts = new HashMap<>();

    public void save(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account findById(int id) {
        return accounts.get(id);
    }
}
