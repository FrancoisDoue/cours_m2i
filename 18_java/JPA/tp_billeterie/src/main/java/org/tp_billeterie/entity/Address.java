package org.tp_billeterie.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Data @SuperBuilder
@NoArgsConstructor @AllArgsConstructor
@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String address;

    protected String city;
}
