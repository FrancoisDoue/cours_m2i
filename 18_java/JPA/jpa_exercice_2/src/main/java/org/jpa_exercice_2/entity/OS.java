package org.jpa_exercice_2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class OS {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "os_id")
    private int id;
    private String name;

}
