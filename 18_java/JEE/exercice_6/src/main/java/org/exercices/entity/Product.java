package org.exercices.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String ref;
    private LocalDate buyDate;
    private double price;
    private int quantity;

    @Column(name = "image_url")
    private String imageUrl;

    public Product(String brand, String ref, LocalDate buyDate, double price, int quantity) {
        this.brand = brand;
        this.ref = ref;
        this.buyDate = buyDate;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
