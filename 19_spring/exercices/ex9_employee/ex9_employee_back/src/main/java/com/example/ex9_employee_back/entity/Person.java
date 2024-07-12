package com.example.ex9_employee_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String firstname;
    protected String lastname;
    protected String identificationNumber;
    protected String address;
    protected String phone;
    @Column(unique = true, nullable = false)
    protected String email;
    protected LocalDate birthDate;
    protected String observation;

}
