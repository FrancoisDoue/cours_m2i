package org.exercice_1.repository;

import lombok.Data;
import org.exercice_1.entity.Product;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LocalDateType;

import javax.persistence.Query;
import java.time.LocalDate;
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

    public List<Product> getByPriceHigherThan(double price) {
        session = factory.openSession();
        List<Product> products = session.createQuery("from Product where price > :price", Product.class)
                .setParameter("price", price, DoubleType.INSTANCE)
                .getResultList();
        session.close();
        return products;
    }

    public List<Product> getByDateBetween(LocalDate start, LocalDate end) {
        session = factory.openSession();
        List<Product> products = session.createQuery("from Product where buyingDate between :start and :end", Product.class)
                .setParameter("start", start, LocalDateType.INSTANCE)
                .setParameter("end", end, LocalDateType.INSTANCE)
                .getResultList();
        session.close();
        return products;
    }

    public List getByStockLowerThan(int stock) {
        session = factory.openSession();
        List products = session.createQuery("select id, reference from Product where stock < :stock")
                .setParameter("stock", stock, IntegerType.INSTANCE)
                .getResultList();
        session.close();
        return products;
    }

    public int deleteByBrand(String brand) {
        session = factory.openSession();
        int result = session.createQuery("delete from Product where brand = :brand")
                .setParameter("brand", brand)
                .executeUpdate();
        session.close();
        return result;
    }



}
