package com.example.__spring_demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("FR")
@Service("bonjour")
public class GreetingsServiceFrench implements GreetingsService {
    @Override
    public String sayHello() {
        return "Baguette!";
    }
}
