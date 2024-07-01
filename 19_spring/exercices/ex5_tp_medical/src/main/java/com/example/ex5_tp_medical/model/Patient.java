package com.example.ex5_tp_medical.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private int id;
    @NotNull(message = "Vous devez renseigner le prénom du patient")
    @NotBlank(message = "Ce champ ne peut pas être vide")
    private String firstName;

    @NotNull(message = "Vous devez renseigner le nom du patient")
    @NotBlank(message = "Ce champ ne peut pas être vide")
    private String lastName;

//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    @NotNull(message = "Vous devez renseigner la date de naissance du patient")
    // TODO find solution
    private LocalDate birthDate;

    public void setBirthDate(String dateToString) {
        this.birthDate = LocalDate.parse(dateToString);
    }

    List<Consultation> consultations = new ArrayList<>();

}
