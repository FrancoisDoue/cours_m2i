package com.example.ex8_cinematheque.repository;

import com.example.ex8_cinematheque.entity.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Integer> {
}
