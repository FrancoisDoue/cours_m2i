package com.example.ex9_employee_back.repository;

import com.example.ex9_employee_back.entity.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

}
