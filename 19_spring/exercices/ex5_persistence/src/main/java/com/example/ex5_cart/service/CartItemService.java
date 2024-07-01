package com.example.ex5_cart.service;

import com.example.ex5_cart.model.CartItem;
import com.example.ex5_cart.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    private List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    private void addToCart(CartItem item) {
        cartItemRepository.save(item);
    }

    private void removeFromCart(CartItem item) {
        cartItemRepository.delete(item);
    }

    private void clearCart() {
        cartItemRepository.deleteAll();
    }

}
