package com.exercise.ex3_student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
}
