package org.exercise_inheritance.repository.impl;

import org.exercise_inheritance.entity.impl.ElectronicProduct;
import org.exercise_inheritance.repository.AbstractEntityRepository;

import java.util.List;

public class ElectronicProductRepository extends AbstractEntityRepository<ElectronicProduct> {
    @Override
    public ElectronicProduct getById(int id) {
        return em.find(ElectronicProduct.class, id);
    }

    @Override
    public List<ElectronicProduct> getAll() {
        return em.createQuery("select ep from ElectronicProduct ep", ElectronicProduct.class).getResultList();
    }
}
