package org.tp_billetterie.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Data @SuperBuilder
@NoArgsConstructor @AllArgsConstructor
@Entity @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String address;

    @NonNull
    protected String city;
}
