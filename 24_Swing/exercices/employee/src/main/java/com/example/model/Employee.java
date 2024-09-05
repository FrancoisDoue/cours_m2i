package com.example.model;

import com.example.util.constant.RoleType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String lastname;
    private RoleType role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;



}
