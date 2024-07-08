package com.example.ex8_cinematheque.repository;

import com.example.ex8_cinematheque.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
