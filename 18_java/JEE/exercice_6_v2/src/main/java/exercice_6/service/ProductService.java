package exercice_6.service;

import exercice_6.entity.Product;
import exercice_6.repository.impl.ImageRepository;
import exercice_6.repository.impl.ProductRepository;
import exercice_6.util.HibernateManager;

import java.time.LocalDate;
import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public ProductService() {
        this.productRepository = new ProductRepository(HibernateManager.getFactory());
        this.imageRepository = new ImageRepository(HibernateManager.getFactory());
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.find(id);
    }

    public void addProduct(String brand, String reference, String doublePrice, String intQty, String buyAt) throws RuntimeException {
        Product product;
        try {
            product = new Product(
                    brand,
                    reference,
                    Double.parseDouble(doublePrice),
                    Integer.parseInt(intQty),
                    LocalDate.parse(buyAt)
            );
            productRepository.create(product);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

}
