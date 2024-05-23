package org.exercise_inheritance.repository;

import org.exercise_inheritance.util.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractEntityRepository<T> {
    protected final EntityManager em;

    public AbstractEntityRepository() {
        em = DatabaseManager.getInstance().getEm();
    }

    public abstract T getById(int id);

    public abstract List<T> getAll();

    public T save(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    public T update(T entity){
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    public boolean delete(T entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        return em.contains(entity);
    }
}
