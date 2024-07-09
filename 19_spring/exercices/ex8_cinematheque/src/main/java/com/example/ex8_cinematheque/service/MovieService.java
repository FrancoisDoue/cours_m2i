package com.example.ex8_cinematheque.service;

import com.example.ex8_cinematheque.dto.MovieDTOPost;
import com.example.ex8_cinematheque.entity.Director;
import com.example.ex8_cinematheque.entity.Movie;
import com.example.ex8_cinematheque.exception.NotFoundException;
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

    public List<Movie> findAllByDirectorId(int id) {
        Director director = directorService.getDirectorById(id);
        return (List<Movie>) movieRepository.findByDirector(director);
    }

    public List<Movie> getAllMovies() {

        return (List<Movie>) movieRepository.findAll();
    }

    public Movie createMovie(MovieDTOPost moviePost) {
        Movie movie = moviePost.toEntity();
        movie.setDirector(directorService.getDirectorById(moviePost.getDirector()));
        return movieRepository.save(movie);
    }

    public void deleteMovie(int id) {
        Movie movie = this.getMovieById(id);
        movieRepository.delete(movie);
    }

    public Movie updateMovie(int id, MovieDTOPost moviePost) {
        if (!movieRepository.existsById(id)) throw new NotFoundException("Movie not found");
        Movie movie = moviePost.toEntity();
        movie.setDirector(directorService.getDirectorById(moviePost.getDirector()));
        movie.setId(id);
        return movieRepository.save(movie);
    }
}
