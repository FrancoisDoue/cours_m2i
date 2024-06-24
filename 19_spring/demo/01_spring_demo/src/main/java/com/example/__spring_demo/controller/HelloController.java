package com.example.__spring_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String sayHello() {
        System.out.println("On sayHello : hello");
        return "hello";
    }

    @RequestMapping("/coucou")
    @ResponseBody
    public List<String> getPersons() {
        System.out.println("On list : list");

        return List.of("toto", "tata", "titi");
    }

    @RequestMapping("/home/person")
    public String homePerson(Model model) {
        System.out.println("On home/person : home");
        model.addAttribute("firstname", "Georges");
        model.addAttribute("lastname", "Abitbol");

        List<String> persons = List.of("toto", "tata", "titi");
//        List<String> persons = List.of();

        model.addAttribute("persons", persons);
        return "person/details";
    }
}
