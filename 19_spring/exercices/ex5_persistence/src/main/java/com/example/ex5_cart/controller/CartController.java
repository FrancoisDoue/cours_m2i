package com.example.ex5_cart.controller;

import com.example.ex5_cart.model.Furniture;
import com.example.ex5_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("items", cartService.getAllCartItems());
        return "cart-list";
    }

    @PostMapping
    public String addItemToCart(@ModelAttribute("furniture") Furniture furniture) {
        cartService.addToCart(furniture, furniture.getStock());
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeItemFromCart(@PathVariable long id) {
        cartService.removeFromCart(id);
        return "redirect:/cart";
    }

    @GetMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

}
