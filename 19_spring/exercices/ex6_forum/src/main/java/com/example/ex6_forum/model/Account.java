package com.example.ex6_forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
//    @NotNull
//    @NotBlank
    private String username;

    @Column(unique = true, nullable = false)
//    @NotNull
//    @Pattern(regexp = "^[\\w-.+]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @Column(nullable = false)
//    @NotNull
//    @NotBlank
    private String password;

}
