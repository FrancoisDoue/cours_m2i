
package org.example.model;

public class Quote {

    private String id;
    private int price;

    public Quote() {}

    public Quote(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" + "id=" + id + ", price=" + price + '}';
    }
}
