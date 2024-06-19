package exercice_6.service;

import exercice_6.repository.impl.ImageRepository;
import exercice_6.repository.impl.ProductRepository;
import exercice_6.util.HibernateManager;

public class ProductService {

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public ProductService() {
        this.productRepository = new ProductRepository(HibernateManager.getFactory());
        this.imageRepository = new ImageRepository(HibernateManager.getFactory());
    }


}
