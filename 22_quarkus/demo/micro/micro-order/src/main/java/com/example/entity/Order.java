package com.example.entity;

import com.example.dto.ClientDTO;
import com.example.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private LocalDateTime orderDate;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "client_id")
    private Long clientId;

    @Transient
    private ProductDTO productDTO;
    @Transient
    private ClientDTO clientDTO;
}
