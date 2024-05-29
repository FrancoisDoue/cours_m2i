package org.exercice_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.type.SerializableType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
// TODO jeter un oeil aux proxy
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String reference;
    private LocalDate buyingDate;
    private double price;
    private int stock;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Image> images;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Comment> comments;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", reference='" + reference + '\'' +
                ", buyingDate=" + buyingDate +
                ", price=" + price +
                ", stock=" + stock +
//                ", comments=" + comments +
//                ", images=" + images +
                '}';
    }
}
