package org.exercices.exercice_5;

import java.util.List;

public class Shop {

    List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public void update() {
        products.forEach(product -> {
            product.setSellIn(product.getSellIn() - 1);
            if (product.getQuality() > 50) product.setQuality(50);
            if (product.getName().equalsIgnoreCase("Brie vieilli")) {
                product.setQuality(product.getQuality() + 1);
            } else {
                if (product.getQuality() > 0) {
                    product.setQuality(
                            product.getQuality() - ((product.getType().equalsIgnoreCase("Produit laitier") || product.getSellIn() <= 0) ? 2 : 1)
                    );
                }
            }
        });
    }

    public List<Product> getProducts() {
        return products;
    }
}
