package org.bdd_exo_1.repository.impl;

import org.bdd_exo_1.entity.Product;
import org.bdd_exo_1.repository.ARepository;

import java.util.List;

public class ProductRepository extends ARepository<Product> {
    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
