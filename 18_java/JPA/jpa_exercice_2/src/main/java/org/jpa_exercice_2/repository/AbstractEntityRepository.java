package org.jpa_exercice_2.repository;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Getter
public abstract class AbstractEntityRepository<T> {
    protected final EntityManager em;

    public AbstractEntityRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_exercice_2");
        em = emf.createEntityManager();
    }

    public abstract T getById(int id);
    public abstract List<T> getAll();
    public abstract T save(T entity);
    public abstract T update(T entity);
    public abstract boolean delete(T entity);

}
