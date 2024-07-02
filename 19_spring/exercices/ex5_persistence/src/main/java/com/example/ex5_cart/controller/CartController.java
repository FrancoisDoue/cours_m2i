package com.example.ex5_cart.controller;

import com.example.ex5_cart.model.Furniture;
import com.example.ex5_cart.service.CartItemService;
import com.example.ex5_cart.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartItemService cartItemService;

    @Autowired
    public CartController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("items", cartItemService.getAllCartItems());
        return "cart-list";
    }

    @PostMapping
    public String addItemToCart(@ModelAttribute("furniture") Furniture furniture, Model model) {
        System.out.println("productId: " + furniture.getId());
        System.out.println("quantity: " + furniture.getStock());
        return "redirect:/cart";
    }

}
