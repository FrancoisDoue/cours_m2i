package exercice_6.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String reference;
    private double price;
    private int quantity;
    private LocalDate buyAt;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product")
    private List<Image> images;

    public Product() {}

    public Product(String brand, String reference, double price, int quantity, LocalDate buyAt) {
        this.brand = brand;
        this.reference = reference;
        this.price = price;
        this.quantity = quantity;
        this.buyAt = buyAt;
    }

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public LocalDate getBuyAt() {
        return buyAt;
    }

    public void setBuyAt(LocalDate buyAt) {
        this.buyAt = buyAt;
    }
}
