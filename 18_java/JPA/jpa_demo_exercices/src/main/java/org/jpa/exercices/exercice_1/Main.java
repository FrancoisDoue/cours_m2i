package org.jpa.exercices.exercice_1;

import org.jpa.exercices.exercice_1.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_exercice_1");
//        EntityManager em = emf.createEntityManager();
//        List<Product> products = List.of(
//                Product.builder().name("Processor").build(),
//                Product.builder().name("Computer").description("Fully built post computer").build(),
//                Product.builder().name("Monitor").build()
//        );
//        // create
//        em.getTransaction().begin();
//        products.forEach(em::persist);
//        em.getTransaction().commit();
//
//        try {
//            // read
//            Product product = em.find(Product.class, 2L);
//            if (product != null) {
//                System.out.println("product = " + product);
//                product.setDescription("Super ordinateur");
//                // update
//                em.getTransaction().begin();
//                em.merge(product);
//                em.getTransaction().commit();
//            }
//            // read all
//            List<Product> allProducts = em.createQuery("Select p from Product p", Product.class).getResultList();
//            allProducts.forEach(System.out::println);
//
//            // delete
//            em.getTransaction().begin();
//            em.remove(allProducts.stream().filter(e -> e.getName()
//                    .equalsIgnoreCase("monitor"))
//                    .findFirst().get()
//            );
//            em.getTransaction().commit();
//
//        } catch (EntityNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        em.close();
//        emf.close();
    }

}
