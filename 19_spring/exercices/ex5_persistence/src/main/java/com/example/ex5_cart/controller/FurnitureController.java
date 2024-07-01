package com.example.ex5_cart.controller;

import com.example.ex5_cart.model.Furniture;
import com.example.ex5_cart.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/furnitures")
public class FurnitureController {
    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public String products(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurniture());
        return "furniture-list";
    }

    @PostMapping
    public String addFurniture(@ModelAttribute("furniture") Furniture furniture) {
        furnitureService.saveFurniture(furniture);
        return "redirect:/furnitures/" + furniture.getId();
    }

    @GetMapping("/{id}")
    public String furniture(@PathVariable long id, Model model) {
        model.addAttribute("furniture", furnitureService.getFurnitureById(id));
        return "furniture-item";
    }

    @GetMapping("/new")
    public String newFurniture(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "furniture-form";
    }

    @GetMapping("/update/{id}")
    public String updateFurniture(@PathVariable long id, Model model) {
        model.addAttribute("furniture", furnitureService.getFurnitureById(id));
        return "furniture-form";
    }

}
