package com.exercices.ex2_products.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    private UUID id;
    private String name;
    private double price;
    private String category;
}
