package org.jpa_exercice_2.ihm;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.repository.AbstractEntityRepository;

import java.util.List;

public class ComputerRepository extends AbstractEntityRepository<Computer> {
    @Override
    public Computer getById(int id) {
        return em.find(Computer.class, id);
    }

    @Override
    public List<Computer> getAll() {
        return em.createQuery("select c from Computer c", Computer.class).getResultList();
    }

    @Override
    public Computer save(Computer entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public Computer update(Computer entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public boolean delete(Computer entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        return !em.contains(entity);
    }
}
