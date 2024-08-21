package com.example.repository;

import com.example.entity.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

    public List<Order> getOrderByIdClient(Long clientId) {
        return list("clientId", clientId);
    }

}
