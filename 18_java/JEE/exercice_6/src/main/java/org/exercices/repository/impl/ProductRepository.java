package org.exercices.repository.impl;

import org.exercices.entity.Product;
import org.exercices.repository.Repository;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository extends Repository<Product> {

    public ProductRepository(Session session) {
        super(session);
    }

    @Override
    public Product find(int id) {
        return session.get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return session.createQuery("from Product", Product.class).list();
    }
}
