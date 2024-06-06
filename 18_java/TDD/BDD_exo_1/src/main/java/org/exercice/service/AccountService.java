package org.exercice.service;

import jdk.jshell.spi.ExecutionControl;
import org.exercice.entity.Account;
import org.exercice.exception.ExistingUserException;
import org.exercice.exception.InvalidCredentialsException;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    List<Account> accounts = new ArrayList<>();

    public void register(Account account) {
        boolean isExist = accounts.stream().map(Account::getMail).anyMatch(t -> t.equals(account.getMail()));
        if (isExist) throw new ExistingUserException("User already exists");
        accounts.add(account);
    }

    public Account login(String email, String password) {
        Account account = getAccountByMail(email);
        if (account == null || !password.equals(account.getPassword()))
            throw new InvalidCredentialsException("Invalid credentials");
        account.setLogged(true);
        return account;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountByMail(String mail) {
        return accounts.stream().filter(a -> a.getMail().equals(mail)).findFirst().orElse(null);
    }
}
