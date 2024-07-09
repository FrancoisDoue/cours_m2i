package com.example.ex9_employee_back.dto.employee;

import com.example.ex9_employee_back.dto.PersonGetDTO;
import com.example.ex9_employee_back.entity.Absence;
import com.example.ex9_employee_back.entity.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.format.DateTimeFormatter;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeGetDTO extends PersonGetDTO<Employee> {
    private String contractStart;
    private String contractEnd;
    private String occupation;
    private boolean admin;
    private double salary;

    private List<Absence> absences;

    public EmployeeGetDTO(Employee entity) {
        super(entity);
        this.contractStart = entity.getContractStart().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.contractEnd = entity.getContractEnd().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.occupation = entity.getOccupation();
        this.admin = entity.isAdmin();
        this.salary = entity.getSalary();
        this.absences = entity.getAbsences();
    }
}
