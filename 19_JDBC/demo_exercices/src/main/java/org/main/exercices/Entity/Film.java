package org.main.exercices.Entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Film {
    private int idFilm;
    private String title, director, genre;
    private LocalDate releaseDate;

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
