package com.example.ex5_cart.repository;

import com.example.ex5_cart.model.CartItem;
import com.example.ex5_cart.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
