package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Director;
import com.example.ex8_cinematheque.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MovieDTO implements DTOInterface<Movie> {

    private Movie movie;

    @Override
    public Movie toDTO() {
        return Movie.builder()
                .id(this.movie.getId())
                .title(this.movie.getTitle())
                .genre(this.movie.getGenre())
                .description(this.movie.getDescription())
                .releaseDate(this.movie.getReleaseDate())
                .director(new DirectorDTO(movie.getDirector()).toDTO())
                .build();
    }

    @Override
    public Movie toEntity() {
        return this.movie;
    }
}
