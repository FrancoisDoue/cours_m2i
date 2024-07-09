package com.example.ex9_employee_back.service;

import com.example.ex9_employee_back.dto.candidate.CandidatePostDTO;
import com.example.ex9_employee_back.entity.Candidate;
import com.example.ex9_employee_back.exception.NotFoundException;
import com.example.ex9_employee_back.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return (List<Candidate>) candidateRepository.findAll();
    }

    public Candidate getCandidateById(int id) {
        return candidateRepository.findById(id).orElseThrow(() -> new NotFoundException("Candidate not found"));
    }

    public Candidate createCandidate(CandidatePostDTO candidatePost) {
        return candidateRepository.save(candidatePost.toEntity());
    }

    public Candidate updateCandidate(int id, CandidatePostDTO candidatePost) {
        if (!candidateRepository.existsById(id)) throw new NotFoundException("Candidate not found");
        Candidate candidate = candidatePost.toEntity();
        candidate.setId(id);
        return candidateRepository.save(candidate);
    }

    public void deleteCandidateById(int id) {
        if (!candidateRepository.existsById(id)) throw new NotFoundException("Candidate not found");
        candidateRepository.deleteById(id);
    }
}
