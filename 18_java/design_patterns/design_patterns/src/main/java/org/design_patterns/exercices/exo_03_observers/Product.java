package org.design_patterns.exercices.exo_03_observers;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Product implements Subject<Product> {
    private ArrayList<Observer> observers;
    private String productName;
    private int stockLevel;

    public Product(String productName, int stockLevel) {
        this.observers = new ArrayList<>();
        this.productName = productName;
        this.stockLevel = stockLevel;
    }

    @Override
    public void registerObserver(Observer<Product> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<Product> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Product p) {
        observers.forEach(o -> o.update(p));
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
        notifyObservers(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", stockLevel=" + stockLevel +
                '}';
    }
}
