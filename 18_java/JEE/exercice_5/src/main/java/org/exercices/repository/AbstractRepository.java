package org.exercices.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractRepository<T> {
    protected Session session;

    public AbstractRepository(Session session) {
        this.session = session;
    }

    public T create(T entity) {
        session.persist(entity);
        return entity;
    }

    public T update(T entity) {
        session.merge(entity);
        return entity;
    }

    public void delete(T entity) {
        session.remove(entity);
    }

    public abstract T find(int id);

    public abstract List<T> findAll();
}
