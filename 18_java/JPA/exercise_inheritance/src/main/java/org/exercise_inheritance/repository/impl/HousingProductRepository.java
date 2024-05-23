package org.exercise_inheritance.repository.impl;

import org.exercise_inheritance.entity.impl.HousingProduct;
import org.exercise_inheritance.repository.AbstractEntityRepository;

import java.util.List;

public class HousingProductRepository extends AbstractEntityRepository<HousingProduct> {
    @Override
    public HousingProduct getById(int id) {
        return null;
    }

    @Override
    public List<HousingProduct> getAll() {
        return em.createQuery("select hp from HousingProduct hp", HousingProduct.class).getResultList();
    }
}
