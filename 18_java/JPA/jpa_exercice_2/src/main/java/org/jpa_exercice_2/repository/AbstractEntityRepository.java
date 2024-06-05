package org.jpa_exercice_2.repository;

import lombok.Getter;
import org.jpa_exercice_2.util.DBManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Getter
public abstract class AbstractEntityRepository<T> {
    protected final EntityManager em;

    public AbstractEntityRepository() {
        em = DBManager.getInstance().getEm();
    }

    public abstract T getById(int id);

    public abstract List<T> getAll();

    public T save(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    public T update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    public boolean delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        return em.contains(entity);
    }

    public void refresh(T entity) {
        em.getTransaction().begin();
        em.refresh(entity);
        em.getTransaction().commit();
    }

}
