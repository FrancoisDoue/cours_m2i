package org.exo7.repository.impl;

import org.exo7.entity.Image;
import org.exo7.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ImageRepository extends Repository<Image> {
    public ImageRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Image find(int id) {
        return session.get(Image.class, id);
    }

    @Override
    public List<Image> findAll() {
        return session.createQuery("from Image", Image.class).list();
    }
}
