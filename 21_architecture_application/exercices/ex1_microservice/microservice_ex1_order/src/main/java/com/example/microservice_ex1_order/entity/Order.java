package com.example.microservice_ex1_order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity @Table(name = "order_product")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String product;
}
