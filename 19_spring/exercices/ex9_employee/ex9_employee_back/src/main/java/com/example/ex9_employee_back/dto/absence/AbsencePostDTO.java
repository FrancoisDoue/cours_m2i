package com.example.ex9_employee_back.dto.absence;

import com.example.ex9_employee_back.dto.PersonPostDTO;
import com.example.ex9_employee_back.entity.Absence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsencePostDTO {
    private String absenceStart;
    private String absenceEnd;
//    @JsonAlias({"employee", "employeeId", "employee_id"})
//    private int employeeId;

    public Absence toEntity() {
        DateTimeFormatter formatter = PersonPostDTO.FORMATTER;
        Absence absence = new Absence();
        absence.setAbsenceStart(LocalDate.parse(absenceStart, formatter));
        if (absenceEnd != null && !absenceEnd.isEmpty())
            absence.setAbsenceEnd(LocalDate.parse(absenceEnd, formatter));
        return absence;
    }
}
