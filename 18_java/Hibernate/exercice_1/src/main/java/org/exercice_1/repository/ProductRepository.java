package org.exercice_1.repository;

import lombok.Data;
import org.exercice_1.entity.Product;

import java.util.List;

@Data
public class ProductRepository extends BaseRepository<Product> {

    public Product get(int id) {
        session = factory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Product> getAll() {
        session = factory.openSession();
        List<Product> products = session.createQuery("from Product", Product.class).list();
        session.close();
        return products;
    }




}
