package com.example.ex4_recipes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(nullable = false, unique = true)
    private String name;
}
