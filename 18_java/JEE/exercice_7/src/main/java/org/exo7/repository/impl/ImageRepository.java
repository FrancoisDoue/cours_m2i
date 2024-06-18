package org.exo7.repository.impl;

import org.exo7.entity.Image;
import org.exo7.repository.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

public class ImageRepository extends Repository<Image> {
    public ImageRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Image find(int id) {
        session = sessionFactory.openSession();
        Image img = session.get(Image.class, id);
        session.close();
        return img;
    }

    @Override
    public List<Image> findAll() {
        session = sessionFactory.openSession();
        List<Image> images = session.createQuery("from Image", Image.class).list();
        session.close();
        return images;
    }
}
