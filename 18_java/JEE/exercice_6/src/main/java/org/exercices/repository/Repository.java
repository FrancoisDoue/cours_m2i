package org.exercices.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    protected Session session;

    public Repository (Session session) {
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
