package org.exercice_1.repository;

import org.exercice_1.entity.Comment;
import org.exercice_1.entity.Image;
import org.exercice_1.entity.Product;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LocalDateType;

import java.time.LocalDate;
import java.util.List;

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

    public List<Product> getAllByAvgNotation(double notation) {
        session = factory.openSession();
        List<Product> products = session.createQuery("""
                select p from Product p
                    join Comment c on c.product = p
                    group by p having avg(c.note) >= :notation
                """, Product.class)
                .setParameter("notation", notation, DoubleType.INSTANCE)
                .getResultList();
        session.close();
        return products;
    }

    public void addImage(int id, Image image) {
        Product product = get(id);
        image.setProduct(product);
        session = factory.openSession();
        session.beginTransaction();
        session.save(image);
        session.getTransaction().commit();
        session.close();
    }

    public void addComment(int id, Comment comment) {
        Product product = get(id);
        comment.setProduct(product);
        session = factory.openSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();
        session.close();
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
        if (start.isAfter(end)) throw new RuntimeException("Erreur: Date de départ supérieure à date de fin");
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
        session.beginTransaction();
        int result = session.createQuery("delete from Product where brand = :brand")
                .setParameter("brand", brand)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;
    }



}
