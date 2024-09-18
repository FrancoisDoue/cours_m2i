package com.example.accountservice.service;

import com.example.accountservice.entity.Account;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found account with id " + id));
    }

    public boolean haveEnoughBalance(long accountId, float balance) {
        Account account = getAccountById(accountId);
        return account.getBalance() >= balance;
    }

    public Account deacreaseBalance(Long id, Double amount) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }
}
