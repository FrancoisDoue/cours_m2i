package com.example.ex8_cinematheque.controller;

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
//
//    @GetMapping("/films")
//    public ResponseEntity<List<Movie>> getMovies(@RequestParam(name = "director", required = false) Integer directorId) {
//        return ResponseEntity.ok().body(movieService.getAllMovies().stream().map(MovieDTO::toDTO).toList());
//    }
//
//    @PostMapping("/films")
//    public ResponseEntity<MovieDTO> postMovie(@RequestBody Movie movie) {
//        return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/films/{id}")
//    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
//        return ResponseEntity.ok().body(movieService.getMovieById(id));
//    }
//
//    @PutMapping("/films/{id}")
//    public ResponseEntity<MovieDTO> updateMovie(@PathVariable int id, @RequestBody Movie movie) {
//        return ResponseEntity.ok().body(movieService.updateMovie(id, movie));
//    }
//
//    @DeleteMapping("/films/{id}")
//    public ResponseEntity<Movie> deleteMovie(@PathVariable int id) {
//        movieService.deleteMovie(id);
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping("/realisateurs")
//    public ResponseEntity<List<DirectorDTOGet>> getDirectors() {
//        return ResponseEntity.ok().body(directorService.getAllDirectors().stream().map(DirectorDTOGet::new).toList());
//    }
//
//    @PostMapping("/realisateurs")
//    public ResponseEntity<DirectorDTOGet> postDirector(@RequestBody DirectorDTOPost directorPost) {
//        DirectorDTOGet director = new DirectorDTOGet(directorService.createDirector(directorPost));
//        return new ResponseEntity<>(director, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/realisateurs/{id}")
//    public ResponseEntity<Director> getDirectorById(@PathVariable int id) {
//        return ResponseEntity.ok().body(directorService.getDirectorById(id));
//    }
//
//    @PutMapping("/realisateurs/{id}")
//    public ResponseEntity<DirectorDTOGet> updateDirector(@RequestBody DirectorDTOPost directorPost, @PathVariable int id) {
//        DirectorDTOGet director = new DirectorDTOGet(directorService.updateDirector(id, directorPost));
//        return ResponseEntity.ok().body(director);
//    }
//
//    @DeleteMapping("/realisateurs/{id}")
//    public ResponseEntity<Director> deleteDirector(@PathVariable int id) {
//        directorService.deleteDirector(id);
//        return ResponseEntity.noContent().build();
//    }

}
