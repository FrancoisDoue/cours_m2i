package org.jpa_exercice_2.entity;

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
    @Id @GeneratedValue @Column(name = "computer_id")
    private int id;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "identification_id")
    private Identification identification;
}
