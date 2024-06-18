package org.exo7.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Repository<T> {
    protected SessionFactory sessionFactory;
    protected Session session;

    public Repository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T create(T entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(entity);
        } catch (RuntimeException e) {
            System.out.println("Exception occured: " + e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return entity;
    }

    public T update(T entity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.merge(entity);
        } catch (RuntimeException e) {
            System.out.println("Exception occured: " + e);

        } finally {
            session.close();
        }
        return entity;
    }

    public void delete(T entity) {
        session.remove(entity);
    }

    public abstract T find(int id);

    public abstract List<T> findAll();
}
