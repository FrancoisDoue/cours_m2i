package com.example.ex6_forum.controller;

import com.example.ex6_forum.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    private final AccountService accountService;

    @Autowired
    public MainController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String index(Model model) {
        System.out.println("isLogged = " + accountService.isLogged());
        model.addAttribute("isLogged", accountService.isLogged());
        return "index";
    }
}
