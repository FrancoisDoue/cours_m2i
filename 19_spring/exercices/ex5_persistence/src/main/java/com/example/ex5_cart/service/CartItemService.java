package com.example.ex5_cart.service;

import com.example.ex5_cart.model.CartItem;
import com.example.ex5_cart.model.Furniture;
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

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void addToCart(Furniture furniture, int quantity) {
        CartItem cartItem = CartItem.builder()
                .furniture(furniture)
                .quantity(quantity)
                .build();
        cartItemRepository.save(cartItem);
    }

    public void removeFromCart(CartItem item) {
        cartItemRepository.delete(item);
    }

    public void clearCart() {
        cartItemRepository.deleteAll();
    }

}
