package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO implements IDTO<Director> {

    private int id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String nationality;

    @Override
    public Director toEntity() {
        Director director = new Director();
        director.setId(id);
        director.setFirstname(firstname);
        director.setLastname(lastname);
        director.setBirthdate(LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        director.setNationality(nationality);
        return director;
    }

    @Override
    public DirectorDTO fromEntity(Director director) {
        this.id = director.getId();
        this.firstname = director.getFirstname();
        this.lastname = director.getLastname();
        this.birthdate = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(director.getBirthdate());
        this.nationality = director.getNationality();
        return this;
    }
}
