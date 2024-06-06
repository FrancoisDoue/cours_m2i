package org.exercice.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Account account;
    private List<Product> productList;

    public Order(Account account) {
        this.account = account;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
    public void removeProduct(Product product) {
        this.productList.remove(product);
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public List<Product> getProductList() {
        return productList;
    }
}
