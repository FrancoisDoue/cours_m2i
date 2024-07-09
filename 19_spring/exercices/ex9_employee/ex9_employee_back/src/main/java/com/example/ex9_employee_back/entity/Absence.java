package com.example.ex9_employee_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Absence {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate absenceStart;
    private LocalDate absenceEnd;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
}
