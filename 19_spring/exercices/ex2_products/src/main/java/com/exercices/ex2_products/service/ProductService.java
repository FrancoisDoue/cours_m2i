package com.exercices.ex2_products.service;

import com.exercices.ex2_products.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(Product.builder().id(UUID.randomUUID()).name("produit 1").category("Alimentaire").price(12).build());
        products.add(Product.builder().id(UUID.randomUUID()).name("produit 2").category("Meuble").price(50).build());
        products.add(Product.builder().id(UUID.randomUUID()).name("produit 3").category("Alimentaire").price(25.5).build());
        products.add(Product.builder().id(UUID.randomUUID()).name("produit 4").category("Bricolage").price(10).build());
    }


    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Product> getProductsByCategory(List<Product> products, String category) {
        return products.stream().filter(p -> p.getCategory().equalsIgnoreCase(category)).toList();
    }

//    public List<Product> getProductsByCategory(String category) {
//        return getProductsByCategory(products, category);
//    }

    public List<Product> getProductsOverPrice(List<Product> products, double price) {
        return products.stream().filter(p -> p.getPrice() >= price).toList();
    }

//    public List<Product> getProductsOverPrice(double price) {
//        return getProductsOverPrice(products, price);
//    }


}
