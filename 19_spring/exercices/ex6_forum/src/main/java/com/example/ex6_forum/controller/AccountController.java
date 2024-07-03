package com.example.ex6_forum.controller;

import com.example.ex6_forum.model.Account;
import com.example.ex6_forum.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("account", new Account());
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(Account account) {
        System.out.println(account);
        accountService.register(account);
        return "redirect:/account/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(Account account) {
        System.out.println(account);
        accountService.login(account.getEmail(), account.getPassword());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        accountService.logout();
        return "redirect:/account/login";
    }
}
