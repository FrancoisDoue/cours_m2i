package exercice_6.repository.impl;

import exercice_6.entity.Product;
import exercice_6.repository.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductRepository extends Repository<Product> {

    public ProductRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Product find(int id) {
        session = sessionFactory.openSession();
        Product p = session.get(Product.class, id);
        session.close();
        return p;
    }

    @Override
    public List<Product> findAll() {
        session = sessionFactory.openSession();
        List<Product> p = session.createQuery("from Product", Product.class).list();
        session.close();
        return p;
    }
}
