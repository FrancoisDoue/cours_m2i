package com.example.ex9_employee_back.dto.candidate;

import com.example.ex9_employee_back.dto.PersonPostDTO;
import com.example.ex9_employee_back.entity.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatePostDTO extends PersonPostDTO<Candidate> {

    private int rating;
    private String skill;
    private String technicalArea;
    private String jobInterviewDate;

    @Override
    public Candidate toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        Candidate candidate = new Candidate();
        candidate.setFirstname(this.firstname);
        candidate.setLastname(this.lastname);
        candidate.setIdentificationNumber(this.identificationNumber);
        candidate.setAddress(this.address);
        candidate.setPhone(this.phone);
        candidate.setEmail(this.email);
        candidate.setBirthDate(LocalDate.parse(this.birthDate, FORMATTER));
        candidate.setObservation(this.observation);
        candidate.setSkill(this.skill);
        candidate.setRating(this.rating);
        if (this.technicalArea != null && !this.technicalArea.isEmpty())
            candidate.setTechnicalArea(this.technicalArea);

        if (this.jobInterviewDate != null && !this.jobInterviewDate.isEmpty())
            candidate.setJobInterviewDate(LocalDateTime.parse(this.jobInterviewDate, formatter));
        return candidate;
    }
}
