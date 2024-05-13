package org.main.exercices.DAO;

import lombok.Getter;
import org.main.exercices.Entity.Film;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FilmDAO {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String request;
    private ResultSet resultSet;
    @Getter
    private List<Film> films;

    public FilmDAO(Connection connection) {
        this.connection = connection;
    }

    public Film createFilm(String title, String director, LocalDate releaseDate, String genre) throws SQLException {
        request = """
                INSERT INTO films(title, director, release_date, genre)
                VALUES (?, ?, ?, ?)
                """;
        preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, director);
        preparedStatement.setDate(3, Date.valueOf(releaseDate));
        preparedStatement.setString(4, genre);

        preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            int filmId = resultSet.getInt(1);
            return Film.builder()
                    .idFilm(filmId)
                    .title(title)
                    .director(director)
                    .releaseDate(releaseDate)
                    .genre(genre)
                    .build();
        }
        return null;
    }

    public List<Film> readFilms() throws SQLException {
        films = new ArrayList<>();
        request = "SELECT * FROM films";
        preparedStatement = connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            films.add(
                Film.builder()
                    .idFilm(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .director(resultSet.getString(3))
                    .releaseDate(resultSet.getDate(4).toLocalDate())
                    .genre(resultSet.getString(5))
                    .build()
            );
        }
        return films;
    }

    public boolean updateFilm(Film film) throws SQLException {
        request = """
                UPDATE films 
                SET title=?, director=?, release_date=?, genre=?
                WHERE id=?""";
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1, film.getTitle());
        preparedStatement.setString(2, film.getDirector());
        preparedStatement.setDate(3, Date.valueOf(film.getReleaseDate()));
        preparedStatement.setString(4, film.getGenre());
        preparedStatement.setInt(5, film.getIdFilm());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteFilm(int id) throws SQLException {
        request = """
                DELETE FROM films
                WHERE id=?""";
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery().rowDeleted();
    }
}
