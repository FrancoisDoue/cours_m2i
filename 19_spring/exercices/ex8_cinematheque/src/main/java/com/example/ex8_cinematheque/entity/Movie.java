package com.example.ex8_cinematheque.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private String description;
    private int duration;
    private String genre;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
