package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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

    @Transactional
    public Product createProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, Product product) {
        Product updatedProduct = getProductsById(id).orElseThrow();
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        productRepository.persist(updatedProduct);
        return updatedProduct;
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
