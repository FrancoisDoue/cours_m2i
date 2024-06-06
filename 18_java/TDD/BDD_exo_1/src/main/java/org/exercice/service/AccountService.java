package org.exercice.service;

import jdk.jshell.spi.ExecutionControl;
import org.exercice.entity.Account;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AccountService {

    List<Account> accounts = new ArrayList<>();

    public boolean register(Account account) {
        boolean isExist = accounts.stream().map(Account::getMail).anyMatch(t -> t.equals(account.getMail()));
        System.out.println("isExist = " + isExist);
        accounts.add(account);
        return true;
    }

    public Account login(String email, String password) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not yet implemented");
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
