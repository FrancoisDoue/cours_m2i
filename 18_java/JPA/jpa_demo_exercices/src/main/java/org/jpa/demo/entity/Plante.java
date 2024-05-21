package org.jpa.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
@Data
@Builder
@AllArgsConstructor
public class Plante {
//    @Id @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String color;

    public Plante() {

    }
}
