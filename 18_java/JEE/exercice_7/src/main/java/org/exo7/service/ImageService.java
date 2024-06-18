package org.exo7.service;

import org.exo7.entity.Image;
import org.exo7.repository.impl.ImageRepository;
import org.exo7.util.HibernateUtil;

import java.util.List;

public class ImageService {

    private final ImageRepository repository;

    public ImageService() {
        this.repository = new ImageRepository(HibernateUtil.getFactory());
    }


    public void create(String fullPath, String imageName) {
        repository.create(
                new Image(fullPath, imageName)
        );
    }

    public List<Image> findAll() {
        return repository.findAll();
    }
}
