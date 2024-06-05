package org.jpa_exercice_2.util;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Getter
public final class DBManager {
    private static DBManager instance;
    private final EntityManagerFactory emf;
    private final EntityManager em;

    private DBManager() {
        emf = Persistence.createEntityManagerFactory("jpa_exercice_2");
        em = emf.createEntityManager();
    }
    public static synchronized DBManager getInstance() {
        if (instance == null) instance = new DBManager();
        return instance;
    }
}
