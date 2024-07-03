package com.example.ex6_forum.service;

import com.example.ex6_forum.model.Account;
import com.example.ex6_forum.repository.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final HttpSession session;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(HttpSession session, AccountRepository accountRepository) {
        this.session = session;
        this.accountRepository = accountRepository;
    }

    public void login(String email, String password) {
        Account account = accountRepository.findByEmail(email);
        if (account != null && account.getPassword().equals(password)) {
            session.setAttribute("account", account);
        }
    }

    public void logout() {
        session.removeAttribute("account");
    }

    public void register(Account account) {
        accountRepository.save(account);
    }

    public boolean isLogged() {
        Account account = (Account) session.getAttribute("account");
        return account != null && account.getId() != 0;
    }

}
