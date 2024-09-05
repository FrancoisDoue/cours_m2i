package com.example.repository;

import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class BaseRepository<T> {
    protected SessionFactory _factory;
    protected Session _session;

    public BaseRepository() {
        _factory = HibernateUtil.getFactory();
    }

    public List<T> saveMultiple(List<T> listEntity){
        _session = _factory.openSession();
        _session.getTransaction().begin();
        listEntity.forEach(_session::save);
        _session.getTransaction().commit();
        _session.close();
        return listEntity;
    }

    public T save (T entity) {
        _session = _factory.openSession();
        _session.getTransaction().begin();
        _session.save(entity);
        _session.getTransaction().commit();
        _session.close();
        return entity;
    }

    public boolean delete(T entity){
        _session = _factory.openSession();
        _session.getTransaction().begin();
        _session.delete(entity);
        _session.getTransaction().commit();
        boolean isContained = _session.contains(entity);
        _session.close();
        return !isContained;
    }

    public T update(T entity) {
        _session = _factory.openSession();
        _session.getTransaction().begin();
        _session.update(entity);
        _session.getTransaction().commit();
        _session.close();
        return entity;
    }

    public abstract T get(int id);
    public abstract List<T> getAll();

}
