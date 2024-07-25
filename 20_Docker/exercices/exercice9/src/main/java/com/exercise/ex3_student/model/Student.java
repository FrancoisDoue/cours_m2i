package com.exercise.ex3_student.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "Ce champ ne peut pas être vide")
    @NotBlank(message = "Ce champ ne peut pas être vide")
    private String firstname;

    @NotNull(message = "Ce champ ne peut pas être vide")
    @NotBlank(message = "Ce champ ne peut pas être vide")
    private String lastname;

    @Min(value = 16, message = "Âge minimum requis: 16 ans")
    private int age;

    @NotNull(message = "Ce champ ne peut pas être vide")
    @NotBlank(message = "Ce champ ne peut pas être vide")
    @Pattern(regexp = "^[\\w-.+]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email invalide")
    private String email;
}
