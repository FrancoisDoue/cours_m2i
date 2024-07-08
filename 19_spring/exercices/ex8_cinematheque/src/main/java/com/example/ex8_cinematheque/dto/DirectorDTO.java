package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO implements DTOInterface<Director> {

    private Director director;

    @Override
    public Director toDTO() {
        return Director.builder()
                .id(director.getId())
                .birthdate(director.getBirthdate())
                .firstname(director.getFirstname())
                .lastname(director.getLastname())
                .build();
    }

    @Override
    public Director toEntity() {
        return null;
    }

}
