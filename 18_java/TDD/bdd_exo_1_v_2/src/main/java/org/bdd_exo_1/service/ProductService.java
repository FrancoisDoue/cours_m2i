package org.bdd_exo_1.service;

import org.bdd_exo_1.entity.Product;
import org.bdd_exo_1.repository.impl.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository pRepository;

    public ProductService(ProductRepository pRepository) {
        this.pRepository = pRepository;
    }

    public List<Product> searchByName(String name) {
        return pRepository.getAll().stream().filter(
                p -> p.getName().toLowerCase().contains(name.toLowerCase())
        ).toList();
    }

    public List<Product> searchByCategory(String category) {
        return pRepository.getAll().stream().filter(p -> p.getCategory().equals(category)).toList();
    }

    public List<String> getCategories() {
        return pRepository.getAll().stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet()).stream().toList();
    }
}
