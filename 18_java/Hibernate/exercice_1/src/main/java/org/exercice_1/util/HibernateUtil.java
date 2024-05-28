package org.exercice_1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {

    private static SessionFactory factory;

    private HibernateUtil() {}


    public static synchronized SessionFactory getFactory() {
        if (factory == null) {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        }
        return factory;
    }


}
