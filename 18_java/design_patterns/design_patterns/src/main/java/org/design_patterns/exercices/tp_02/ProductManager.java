package org.design_patterns.exercices.tp_02;

import org.design_patterns.exercices.tp_02.entity.Product;
import org.design_patterns.exercices.tp_02.factory.ProductFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {
    private Map<String, ProductFactory> factories = new HashMap<>();
    private List<Product> products = new ArrayList<>();

    public ProductManager(Map<String, ProductFactory> factories) {
        factories.forEach(this::addFactory);
    }

    public void addFactory(String name, ProductFactory factory) {
        factories.put(name, factory);
    }

    public Map<String, ProductFactory> getFactories() {
        return factories;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
