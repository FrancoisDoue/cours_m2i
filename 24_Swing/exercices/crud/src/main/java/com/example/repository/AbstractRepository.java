package com.example.repository;

import com.example.util.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractRepository<T> {

    protected final EntityManager _em;

    public AbstractRepository() {
        _em = DatabaseManager.getInstance().getEm();
    }

    public abstract T getById(int id);
    public abstract List<T> getAll();
    public T save(T entity) {
        _em.getTransaction().begin();
        _em.persist(entity);
        _em.getTransaction().commit();
        return entity;
    }
    public boolean delete(T entity) {
        _em.getTransaction().begin();
        _em.remove(entity);
        _em.getTransaction().commit();
        return !_em.contains(entity);
    }
    public T update(T entity) {
        _em.getTransaction().begin();
        _em.merge(entity);
        _em.getTransaction().commit();
        return entity;
    }
}
