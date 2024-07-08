package com.example.ex8_cinematheque.service;

import com.example.ex8_cinematheque.dto.MovieDTO;
import com.example.ex8_cinematheque.entity.Director;
import com.example.ex8_cinematheque.entity.Movie;
import com.example.ex8_cinematheque.exception.NotFoundException;
import com.example.ex8_cinematheque.repository.DirectorRepository;
import com.example.ex8_cinematheque.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    @Autowired
    public MovieService(MovieRepository movieRepository, DirectorService directorService) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Movie not found"));
    }

    public List<MovieDTO> findAllByDirectorId(int id) {
        Director director = directorService.getDirectorById(id);
        return ((List<Movie>) movieRepository.findByDirector(director)).stream().map(MovieDTO::new).toList();
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        return movies.stream().map(MovieDTO::new).toList();
    }

    public MovieDTO createMovie(Movie movie) {
        movie.setDirector(directorService.getDirectorById(movie.getDirector().getId()));
        return new MovieDTO(movieRepository.save(movie));
    }

    public void deleteMovie(int id) {
        Movie movie = this.getMovieById(id);
        movieRepository.delete(movie);
    }

    public MovieDTO updateMovie(int id, Movie movie) {
        if (!movieRepository.existsById(id)) throw new NotFoundException("Movie not found");
        movie.setId(id);
        return new MovieDTO(movieRepository.save(movie));
    }
}
