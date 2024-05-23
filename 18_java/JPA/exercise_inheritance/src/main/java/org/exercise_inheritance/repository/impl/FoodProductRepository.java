package org.exercise_inheritance.repository.impl;

import org.exercise_inheritance.entity.impl.FoodProduct;
import org.exercise_inheritance.repository.AbstractEntityRepository;

import java.util.List;

public class FoodProductRepository extends AbstractEntityRepository<FoodProduct> {
    @Override
    public FoodProduct getById(int id) {
        return em.find(FoodProduct.class, id);
    }

    @Override
    public List<FoodProduct> getAll() {
        return em.createQuery("select fp from FoodProduct fp", FoodProduct.class).getResultList();
    }
}
