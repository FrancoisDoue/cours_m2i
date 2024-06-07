package org.bdd_exo_1.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Account account;
    private final List<Product> products;
    private boolean isValidate;

    public Order(Account account) {
        this.account = account;
        this.products = new ArrayList<>();
        this.isValidate = false;
    }

    public Account getAccount() {
        return account;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public boolean isValidate() {
        return isValidate;
    }

    public void setValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
