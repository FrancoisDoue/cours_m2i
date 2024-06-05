package org.jpa_exercice_2.repository;

import org.jpa_exercice_2.entity.OS;

import java.util.List;

public class OSRepository extends AbstractEntityRepository<OS> {
    @Override
    public OS getById(int id) {
        return em.find(OS.class, id);
    }

    @Override
    public List<OS> getAll() {
        return em.createQuery("select os from OS os", OS.class).getResultList();
    }
}
