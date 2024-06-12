package org.exercices.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractRepository<T> {
    protected SessionFactory factory;
    protected Session session;

    public AbstractRepository(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    public T create(T entity) {
        session = factory.openSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public T update(T entity) {
        session = factory.openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public void delete(T entity) {
        session = factory.openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }

    public abstract T find(int id);

    public abstract List<T> findAll();
}
