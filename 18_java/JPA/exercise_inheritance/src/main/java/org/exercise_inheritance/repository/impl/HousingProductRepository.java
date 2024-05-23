package org.exercise_inheritance.repository.impl;

import org.exercise_inheritance.entity.impl.HousingProduct;
import org.exercise_inheritance.repository.AbstractEntityRepository;
import org.exercise_inheritance.repository.RepositoryStrategy;

import java.util.List;

public class HousingProductRepository
        extends AbstractEntityRepository<HousingProduct>
        implements RepositoryStrategy<HousingProduct>
{
    @Override
    public HousingProduct getById(long id) {
        return null;
    }

    @Override
    public List<HousingProduct> getAll() {
        return em.createQuery("select hp from HousingProduct hp", HousingProduct.class).getResultList();
    }
}
