package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Director;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DirectorDTOGet {

    private int id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String nationality;

    public DirectorDTOGet(Director director) {
        id = director.getId();
        firstname = director.getFirstname();
        lastname = director.getLastname();
        birthdate = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(director.getBirthdate());
        nationality = director.getNationality();
    }
}
