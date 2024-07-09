package com.example.ex9_employee_back.repository;

import com.example.ex9_employee_back.entity.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

}
