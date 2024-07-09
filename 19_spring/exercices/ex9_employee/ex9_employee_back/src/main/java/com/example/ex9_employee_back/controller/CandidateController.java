package com.example.ex9_employee_back.controller;

import com.example.ex9_employee_back.dto.candidate.CandidateGetDTO;
import com.example.ex9_employee_back.dto.candidate.CandidatePostDTO;
import com.example.ex9_employee_back.entity.Candidate;
import com.example.ex9_employee_back.service.CandidateService;
import com.example.ex9_employee_back.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService, EmployeeService employeeService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<CandidateGetDTO>> getCandidates() {
        List<CandidateGetDTO> candidates = candidateService.getAllCandidates().stream().map(CandidateGetDTO::new).toList();
        return ResponseEntity.ok(candidates);
    }

    @PostMapping
    public ResponseEntity<CandidateGetDTO> addCandidate(@RequestBody CandidatePostDTO candidatePost) {
        Candidate candidate = candidateService.createCandidate(candidatePost);
        return new ResponseEntity<>(new CandidateGetDTO(candidate), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateGetDTO> getCandidateById(@PathVariable int id) {
        return ResponseEntity.ok(new CandidateGetDTO(candidateService.getCandidateById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateGetDTO> updateCandidate(@PathVariable int id, @RequestBody CandidatePostDTO candidatePost) {
        return ResponseEntity.ok(new CandidateGetDTO(candidateService.updateCandidate(id, candidatePost)));
    }

    public ResponseEntity<Void> deleteCandidate(@PathVariable int id) {
        candidateService.deleteCandidateById(id);
        return ResponseEntity.noContent().build();
    }

}
