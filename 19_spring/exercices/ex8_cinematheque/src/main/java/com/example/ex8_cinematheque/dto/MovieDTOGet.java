package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTOGet {
    private int id;
    private String title;
    private String description;
    private String releaseDate;
    private int duration;
    private String genre;
    private DirectorDTOGet director;

    public MovieDTOGet(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.releaseDate = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(movie.getReleaseDate());
        this.duration = movie.getDuration();
        this.genre = movie.getGenre();
        if (movie.getDirector() != null)
            this.director = new DirectorDTOGet(movie.getDirector());
    }
}
