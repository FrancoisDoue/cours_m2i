package org.exercice_1.repository;

import org.exercice_1.entity.Image;
import org.exercice_1.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ImageRepository extends BaseRepository<Image> {

    @Override
    public Image get(int id) {
        session = factory.openSession();
        Image image = session.get(Image.class, id);
        session.close();
        return image;
    }

    @Override
    public List<Image> getAll() {
        session = factory.openSession();
        List<Image> images = session.createQuery("from Image" ,Image.class).list();
        session.close();
        return images;
    }

    public List<Image> getAllFromProduct(Product product) {
        session = factory.openSession();
        List<Image> images = session.createQuery("from Image i where i.product = :product", Image.class)
                .setParameter("product", product)
                .getResultList();
        session.close();
        return images;
    }
}
