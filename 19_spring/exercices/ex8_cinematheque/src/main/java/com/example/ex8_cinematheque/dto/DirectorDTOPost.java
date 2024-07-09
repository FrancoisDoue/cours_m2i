package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTOPost {

    private String firstname;
    private String lastname;
    private String birthdate;
    private String nationality;

    public Director toEntity() {
        Director director = new Director();
        director.setFirstname(firstname);
        director.setLastname(lastname);
        director.setBirthdate(LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        director.setNationality(nationality);
        return director;
    }

}
