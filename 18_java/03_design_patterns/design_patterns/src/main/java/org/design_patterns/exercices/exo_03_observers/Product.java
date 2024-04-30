package org.design_patterns.exercices.exo_03_observers;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Product implements ProductSubject {
    private ArrayList<ProductObserver> observers;
    private String productName;
    private int stockLevel;

    public Product(String productName, int stockLevel) {
        this.observers = new ArrayList<>();
        this.productName = productName;
        this.stockLevel = stockLevel;
    }

    @Override
    public void registerObserver(ProductObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(ProductObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", stockLevel=" + stockLevel +
                '}';
    }
}
