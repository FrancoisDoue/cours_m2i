package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTOPost {
    private String title;
    private String description;
    private String releaseDate;
    private String genre;
    private int duration;
    private int director;

    public Movie toEntity() {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setReleaseDate(LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        movie.setGenre(genre);
        movie.setDuration(duration);
        return movie;
    }

}
