package com.example.__spring_demo.controller;

import com.example.__spring_demo.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerSet {

    private final GreetingsService greetingsService;

//    @Autowired
    public HelloControllerSet(@Qualifier("bonjour") GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @RequestMapping("/hello-test")
    public String sayHello () {
        System.out.println(greetingsService.sayHello());
        System.out.println("On hello test");
        return "hello";

    }
}
