package com.example.ex9_employee_back.dto.candidate;

import com.example.ex9_employee_back.dto.PersonGetDTO;
import com.example.ex9_employee_back.entity.Candidate;
import lombok.*;

import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Data
public class CandidateGetDTO extends PersonGetDTO<Candidate> {
    private int rating;
    private String skill;
    private String technicalArea;
    private String jobInterviewDate;

    public CandidateGetDTO(Candidate entity) {
        super(entity);
        this.rating = entity.getRating();
        this.skill = entity.getSkill();
        this.technicalArea = entity.getTechnicalArea();
        if (entity.getJobInterviewDate() != null)
            this.jobInterviewDate = entity.getJobInterviewDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
