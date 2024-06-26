package org.tp_billetterie.repository;

import org.tp_billetterie.util.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractRepository<T> {
    protected final EntityManager em;
    public AbstractRepository() {
        em = DatabaseManager.getInstance().getEm();
    }

    public abstract T getById(int id);
    public abstract List<T> getAll();
    public T save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }
    public boolean delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        return !em.contains(entity);
    }
    public T update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }
}
