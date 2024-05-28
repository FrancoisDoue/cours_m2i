package org.exercice_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String reference;
    private LocalDate buyingDate;
    private double price;
    private int stock;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", reference='" + reference + '\'' +
                ", buyingDate=" + buyingDate +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
