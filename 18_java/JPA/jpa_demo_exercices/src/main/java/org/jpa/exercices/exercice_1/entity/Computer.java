package org.jpa.exercices.exercice_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Computer {
    @Id @GeneratedValue
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "id_identification")
    private Identification identification;
}
