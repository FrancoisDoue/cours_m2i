package org.exercise_inheritance.repository.impl;

import org.exercise_inheritance.entity.impl.ElectronicProduct;
import org.exercise_inheritance.repository.AbstractEntityRepository;
import org.exercise_inheritance.repository.RepositoryStrategy;

import java.util.List;

public class ElectronicProductRepository
        extends AbstractEntityRepository<ElectronicProduct>
        implements RepositoryStrategy<ElectronicProduct>
{
    @Override
    public ElectronicProduct getById(long id) {
        return em.find(ElectronicProduct.class, id);
    }

    @Override
    public List<ElectronicProduct> getAll() {
        return em.createQuery("select ep from ElectronicProduct ep", ElectronicProduct.class).getResultList();
    }
}
