package com.example.ex8_cinematheque.service;

import com.example.ex8_cinematheque.dto.MovieDTO;
import com.example.ex8_cinematheque.entity.Movie;
import com.example.ex8_cinematheque.exception.NotFoundException;
import com.example.ex8_cinematheque.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Movie not found"));
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        return movies.stream().map(m -> new MovieDTO().fromEntity(m)).toList();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(int id) {
        Movie movie = this.getMovieById(id);
        movieRepository.delete(movie);
    }

    public Movie updateMovie(int id, Movie movie) {
        if (!movieRepository.existsById(id)) throw new NotFoundException("Movie not found");
        movie.setId(id);
        return movieRepository.save(movie);
    }
}
