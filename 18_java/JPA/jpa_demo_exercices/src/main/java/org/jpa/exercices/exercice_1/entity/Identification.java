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
public class Identification {
    @Id @GeneratedValue
    @Column(name = "id_identification")
    private int id;
    private String ip;
    @OneToOne(mappedBy = "identification")
    private Computer computer;
}
