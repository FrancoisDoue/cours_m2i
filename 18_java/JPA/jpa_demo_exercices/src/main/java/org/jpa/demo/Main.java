package org.jpa.demo;

import org.jpa.demo.entity.Plante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
//        EntityManager em = emf.createEntityManager();
////        Plante plante = Plante.builder().name("Rose").age(1).color("red").build();
//
////        em.getTransaction().begin();
////        em.persist(plante);
////        em.getTransaction().commit();
//        try {
//            System.out.println(em.find(Plante.class, 1L));
//        } catch (EntityNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        em.close();
//        emf.close();
    }
}
