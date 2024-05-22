package org.jpa_exercice_2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Identification {

    @Id @GeneratedValue @Column(name = "identification_id")
    private int id;

    private String ip;

    @OneToOne(mappedBy = "identification", fetch = FetchType.EAGER)
    private Computer computer;
}
