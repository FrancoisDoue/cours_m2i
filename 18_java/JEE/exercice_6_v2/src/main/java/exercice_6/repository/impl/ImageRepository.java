package exercice_6.repository.impl;

import exercice_6.entity.Image;
import exercice_6.entity.Product;
import exercice_6.repository.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

public class ImageRepository extends Repository<Image> {
    public ImageRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Image find(int id) {
        session = sessionFactory.openSession();
        Image image = session.get(Image.class, id);
        session.close();
        return image;
    }

    public List<Image> findByProduct(Product product) {
        session = sessionFactory.openSession();
        List<Image> images = session.createQuery("from Image i where i.product = :product", Image.class)
                .setParameter(":product", product)
                .getResultList();
        session.close();
        return images;
    }

    @Override
    public List<Image> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
