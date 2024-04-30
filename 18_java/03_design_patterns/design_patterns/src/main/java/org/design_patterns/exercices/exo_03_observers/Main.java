package org.design_patterns.exercices.exo_03_observers;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Product 1", 50);
        product1.setStockLevel(75);

        product1.registerObserver(new StockManager());
        product1.setStockLevel(product1.getStockLevel()-5);

        product1.registerObserver(new Supplier());
        product1.setStockLevel(product1.getStockLevel()+10);
    }
}
