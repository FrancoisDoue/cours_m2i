package com.example.ex9_employee_back.dto.recruitment;

import com.example.ex9_employee_back.dto.PersonPostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentPostDTO {
    private String contractStart;
    private String contractEnd;
    private String occupation;
    private String password;
    private double salary;


    public LocalDate getContractStart() {
        return LocalDate.parse(contractStart, PersonPostDTO.FORMATTER);
    }

    public LocalDate getContractEnd() {
        return LocalDate.parse(contractEnd, PersonPostDTO.FORMATTER);
    }
}
