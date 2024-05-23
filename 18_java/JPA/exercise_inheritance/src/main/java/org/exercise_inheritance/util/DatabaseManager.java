package org.exercise_inheritance.util;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Getter
public final class DatabaseManager {
    private static DatabaseManager instance;
    private final EntityManagerFactory emf;
    private final EntityManager em;

    private DatabaseManager() {
        emf = Persistence.createEntityManagerFactory("jpa_exercice_inheritance");
        em = emf.createEntityManager();
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) instance = new DatabaseManager();
        return instance;
    }

    public static void close() {
        if (instance != null) {
            instance.getEm().close();
            instance.getEmf().close();
            instance = null;
        }
    }
}
