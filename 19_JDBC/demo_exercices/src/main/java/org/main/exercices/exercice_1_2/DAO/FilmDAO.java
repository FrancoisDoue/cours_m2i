package org.main.exercices.exercice_1_2.DAO;

import lombok.Getter;
import org.main.exercices.exercice_1_2.Entity.Film;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO extends BaseDAO<Film> {

    public FilmDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Film create(Film film) throws SQLException {
        request = """
                INSERT INTO films(title, director, release_date, genre)
                VALUES (?, ?, ?, ?)
                """;
        preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, film.getTitle());
        preparedStatement.setString(2, film.getDirector());
        preparedStatement.setDate(3, Date.valueOf(film.getReleaseDate()));
        preparedStatement.setString(4, film.getGenre());
        if (preparedStatement.executeUpdate() != 1)
            connection.rollback();

        resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next()) {
            film.setIdFilm(resultSet.getInt(1));
            return film;
        }
        return null;
    }

    @Override
    public boolean update(Film film) throws SQLException {
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
        if ( preparedStatement.executeUpdate() != 1 ) {
            connection.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        request = """
                DELETE FROM films
                WHERE id=?""";
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        if (preparedStatement.executeUpdate() != 1 ) {
            connection.rollback();
            return false;
        }
        return true;
    }

    @Override
    public List<Film> getAll() throws SQLException {
        list = new ArrayList<>();
        request = "SELECT * FROM films";
        preparedStatement = connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(
                    Film.builder()
                            .idFilm(resultSet.getInt(1))
                            .title(resultSet.getString(2))
                            .director(resultSet.getString(3))
                            .releaseDate(resultSet.getDate(4).toLocalDate())
                            .genre(resultSet.getString(5))
                            .build()
            );
        }
        return list;
    }

    @Override
    public Film getById(int id) throws SQLException {
        request = """
                SELECT * FROM films
                WHERE id = ?""";
        preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return Film.builder()
                    .idFilm(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .director(resultSet.getString(3))
                    .releaseDate(resultSet.getDate(4).toLocalDate())
                    .genre(resultSet.getString(5))
                    .build();
        return null;
    }

    public Film createFilm(String title, String director, LocalDate releaseDate, String genre) throws SQLException {
        return this.create(
                Film.builder()
                        .title(title)
                        .director(director)
                        .releaseDate(releaseDate)
                        .genre(genre)
                        .build()
        );
    }

    public List<Film> readFilms() throws SQLException {
        return getAll();
    }

    public boolean updateFilm(Film film) throws SQLException {
        return this.update(film);
    }

    public boolean deleteFilm(int id) throws SQLException {
        return this.delete(id);
    }
}
