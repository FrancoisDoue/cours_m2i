package org.bdd_exo_1.service;

import org.bdd_exo_1.entity.Account;
import org.bdd_exo_1.exception.AccountAlreadyExistsException;
import org.bdd_exo_1.exception.InvalidCredentialsException;
import org.bdd_exo_1.repository.impl.AccountRepository;

public class AccountService {
    private AccountRepository aRepository;
    public AccountService(AccountRepository aRepository) {
        this.aRepository = aRepository;
    }

    public void register(Account account) {
//        throw new UnsupportedOperationException("Not supported yet.");
        boolean isExists = getAccount(account.getEmail()) != null;
        if (isExists) throw new AccountAlreadyExistsException("Account already exists");
        aRepository.create(account);
    }

    public Account login(String email, String password) {
        Account account = getAccount(email);
        if (account == null || !password.equals(account.getPassword()))
            throw new InvalidCredentialsException("Invalid credentials");
        account.setLogged(true);
        return account;
    }

    public Account getAccount(String email) {
        return aRepository.getAll().stream().filter(a -> a.getEmail().equals(email)).findFirst().orElse(null);
    }

}
