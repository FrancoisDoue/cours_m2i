package com.example.ex5_cart.service;

import com.example.ex5_cart.model.CartItem;
import com.example.ex5_cart.model.Furniture;
import com.example.ex5_cart.repository.CartItemRepository;
import com.example.ex5_cart.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final FurnitureRepository furnitureRepository;

    @Autowired
    public CartService(CartItemRepository cartItemRepository, FurnitureRepository furnitureRepository) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureRepository = furnitureRepository;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void addToCart(Furniture furniture, int quantity) {
        CartItem cartItem = CartItem.builder()
                .furniture(furniture)
                .quantity(quantity)
                .build();
        Furniture f = furnitureRepository.findById(furniture.getId()).orElse(null);
        if (f != null) {
            f.setStock(f.getStock() - quantity);
            furnitureRepository.save(f);
            cartItemRepository.save(cartItem);
        }
    }

    public void removeFromCart(long id) {
        CartItem cartItem = cartItemRepository.findById(id).orElse(null);
        if (cartItem != null) {
            Furniture f = cartItem.getFurniture();
            f.setStock(f.getStock() + cartItem.getQuantity());
            furnitureRepository.save(f);
            cartItemRepository.delete(cartItem);
        }
    }

    public void clearCart() {
        getAllCartItems().forEach(i -> removeFromCart(i.getId()));
    }

}
