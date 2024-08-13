package com.example.infrastructure_spring_data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity @Table(name = "event")
public class EventEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String title;
    private int availablePlaces;
    private int maxPlaces;
}
