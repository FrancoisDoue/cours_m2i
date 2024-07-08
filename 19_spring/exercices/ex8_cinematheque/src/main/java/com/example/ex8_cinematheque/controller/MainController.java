package com.example.ex8_cinematheque.controller;

import com.example.ex8_cinematheque.dto.DirectorDTO;
import com.example.ex8_cinematheque.dto.MovieDTO;
import com.example.ex8_cinematheque.entity.Director;
import com.example.ex8_cinematheque.entity.Movie;
import com.example.ex8_cinematheque.service.DirectorService;
import com.example.ex8_cinematheque.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class MainController {

    private final MovieService movieService;
    private final DirectorService directorService;

    @Autowired
    public MainController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @GetMapping("/films")
    public ResponseEntity<List<MovieDTO>> films() {
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @PostMapping("/films")
    public ResponseEntity<Movie> films(@RequestBody MovieDTO movieDTO) {
        return new ResponseEntity<>(movieService.createMovie(movieDTO.toEntity()), HttpStatus.CREATED);
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<Movie> film(@PathVariable int id) {
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }

    @GetMapping("/realisateurs")
    public ResponseEntity<List<DirectorDTO>> realisateurs() {
        return ResponseEntity.ok().body(directorService.getAllDirectors());
    }

    @PostMapping("/realisateurs")
    public ResponseEntity<Director> realisateurs(@RequestBody DirectorDTO directorDTO) {
        return new ResponseEntity<>(directorService.createDirector(directorDTO.toEntity()), HttpStatus.CREATED);
    }

    @GetMapping("/realisateurs/{id}")
    public ResponseEntity<Director> realisateur(@PathVariable int id) {
        return ResponseEntity.ok().body(directorService.getDirectorById(id));
    }



}
