package org.exercice.service;

import org.exercice.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public List<Product> searchByName(String name) {
        return products.stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public List<Product> getByCategory(String category) {
        return products.stream().filter(p -> p.getCategory().equals(category)).toList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<String> getCategories() {
        return products.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet()).stream().toList();
    }

}
