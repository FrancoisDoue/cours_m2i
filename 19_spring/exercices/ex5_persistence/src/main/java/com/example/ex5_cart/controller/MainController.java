package com.example.ex5_cart.controller;

import ch.qos.logback.core.model.Model;
import com.example.ex5_cart.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final FurnitureService furnitureService;

    @Autowired
    public MainController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

}
