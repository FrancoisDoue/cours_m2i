package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Movie;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MovieDTO implements IDTO<Movie> {

    private int id;
    private String title;
    private String releaseDate;
    private String description;
    private int duration;
    private String genre;


    @Override
    public Movie toEntity() {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setReleaseDate(LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        movie.setDescription(description);
        movie.setDuration(duration);
        movie.setGenre(genre);
        return movie;
    }

    @Override
    public MovieDTO fromEntity(Movie entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.duration = entity.getDuration();
        this.genre = entity.getGenre();
        this.releaseDate = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(entity.getReleaseDate());
        return this;
    }
}
