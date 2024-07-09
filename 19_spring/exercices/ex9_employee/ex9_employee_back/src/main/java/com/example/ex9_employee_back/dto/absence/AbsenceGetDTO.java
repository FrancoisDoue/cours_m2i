package com.example.ex9_employee_back.dto.absence;

import com.example.ex9_employee_back.dto.employee.EmployeeGetDTO;
import com.example.ex9_employee_back.entity.Absence;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbsenceGetDTO {
    private String absenceStart;
    private String absenceEnd;

    public AbsenceGetDTO(Absence absence) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.absenceStart = formatter.format(absence.getAbsenceStart());
        if (absence.getAbsenceEnd() != null)
            this.absenceEnd = formatter.format(absence.getAbsenceEnd());
    }
}
