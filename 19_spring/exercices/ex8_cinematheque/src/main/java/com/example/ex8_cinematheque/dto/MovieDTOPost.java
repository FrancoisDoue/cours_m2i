package com.example.ex8_cinematheque.dto;

import com.example.ex8_cinematheque.entity.Movie;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTOPost {
    @NotNull @Size(min = 2, max = 100)
    private String title;
    private String description;
    @NotBlank @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "doit correspondre au format \"dd-MM-yyyy\"")
    private String releaseDate;
    private String genre;
    private int duration;
    @NotNull @Min(1)
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
