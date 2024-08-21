package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.listAll();
    }

    public Optional<Product> getProductsById(Long id) {
        return productRepository.findByIdOptional(id);
    }

    public Product createProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        productRepository.persist(product);
        return product;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
