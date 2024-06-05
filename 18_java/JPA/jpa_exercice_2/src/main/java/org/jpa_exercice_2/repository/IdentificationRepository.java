package org.jpa_exercice_2.repository;

import org.jpa_exercice_2.entity.Identification;

import java.util.List;

public class IdentificationRepository extends AbstractEntityRepository<Identification> {

    @Override
    public Identification getById(int id) {
        return em.find(Identification.class, id);
    }

    @Override
    public List<Identification> getAll() {
        return em.createQuery("select i from Identification i", Identification.class).getResultList();
    }
}
