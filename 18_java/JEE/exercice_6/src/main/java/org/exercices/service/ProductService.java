package org.exercices.service;

import org.exercices.entity.Product;
import org.exercices.repository.impl.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;
    private final SessionFactory sessionFactory;
    private Session session;

    public ProductService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product getProduct(int id) {
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        try {
            return productRepository.find(id);
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public List<Product> getAllProducts() {
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        try {
            return productRepository.findAll();
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public Product createProduct(Product product) {
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        session.beginTransaction();
        try {
            Product p = productRepository.create(product);
            session.getTransaction().commit();
            return p;
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Product update(Product product) {
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        session.beginTransaction();
        try {
            Product p = productRepository.update(product);
            session.getTransaction().commit();
            return p;
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public void deleteProduct(int i) {
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        session.beginTransaction();
        try {
            Product p = productRepository.find(i);
            if (p == null)
                throw new RuntimeException("product not found");
            productRepository.delete(p);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
