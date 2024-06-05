package org.jpa_exercice_2.repository;

import org.jpa_exercice_2.entity.Processor;

import java.util.List;

public class ProcessorRepository extends AbstractEntityRepository<Processor> {

    @Override
    public Processor getById(int id) {
        return em.find(Processor.class, id);
    }

    @Override
    public List<Processor> getAll() {
        return em.createQuery("select p from Processor p", Processor.class).getResultList();
    }
}
