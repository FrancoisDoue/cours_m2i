package org.bdd_exo_1.repository.impl;

import org.bdd_exo_1.entity.Order;
import org.bdd_exo_1.repository.ARepository;

import java.util.List;

public class OrderRepository extends ARepository<Order> {

    @Override
    public Order get(int id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(int id) {

    }
}
