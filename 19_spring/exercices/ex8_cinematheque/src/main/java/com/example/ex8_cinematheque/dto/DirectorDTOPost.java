package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Director;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTOPost {

    @NotNull
    @Size(min = 2, max = 20)
    private String firstname;
    @NotNull
    @Size(min = 2, max = 20)
    private String lastname;
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
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
