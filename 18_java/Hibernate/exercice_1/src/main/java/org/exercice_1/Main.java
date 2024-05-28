package org.exercice_1;

import org.exercice_1.entity.Product;
import org.exercice_1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getFactory();
        Session session = factory.openSession();

        session.getTransaction().begin();
        Product product1 = new Product("marque1", "model1", LocalDate.of(2024,5,25), 10., 5);
        Product product2 = new Product("marque2", "model2", LocalDate.of(2024,5,26), 10., 2);
        Product product3 = new Product("marque3", null, LocalDate.of(2024,5,26), 10., 7);
        Product product4 = new Product("marque4", null, LocalDate.of(2024,5,28), 10., 9);
        Product product5 = new Product("marque5", null, LocalDate.of(2024,5,28), 10., 5);

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);

        session.getTransaction().commit();

        Product findedProduct = session.get(Product.class, 2);
        Product productToDelete = session.get(Product.class, 3);
        Product productToUpdate = session.get(Product.class, 1);

        System.out.println(findedProduct);

        session.getTransaction().begin();
        session.delete(productToDelete);
        session.getTransaction().commit();
        System.out.println(productToDelete);

        productToUpdate.setBrand("Un excellent produit");
        session.getTransaction().begin();
        session.update(productToUpdate);
        session.getTransaction().commit();
        System.out.println(productToUpdate);

        session.close();
        factory.close();

    }
}