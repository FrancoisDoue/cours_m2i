package org.bdd_exo_1.service;

import org.bdd_exo_1.entity.Account;
import org.bdd_exo_1.repository.impl.AccountRepository;

public class AccountService {
    private AccountRepository aRepository;
    public AccountService(AccountRepository aRepository) {
        this.aRepository = aRepository;
    }

    public void register(Account account) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Account login(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Account getAccount(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    public boolean logout(Account account) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
}
