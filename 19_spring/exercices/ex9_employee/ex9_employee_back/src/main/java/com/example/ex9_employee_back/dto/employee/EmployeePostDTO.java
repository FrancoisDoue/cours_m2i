package com.example.ex9_employee_back.dto.employee;

import com.example.ex9_employee_back.dto.PersonPostDTO;
import com.example.ex9_employee_back.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePostDTO extends PersonPostDTO<Employee> {
    private String contractStart;
    private String contractEnd;
    private String occupation;
    private String password;
    private boolean admin;
    private double salary;

    @Override
    public Employee toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Employee employee = new Employee();
        employee.setFirstname(this.firstname);
        employee.setLastname(this.lastname);
        employee.setIdentificationNumber(this.identificationNumber);
        employee.setAddress(this.address);
        employee.setPhone(this.phone);
        employee.setEmail(this.email);
        employee.setBirthDate(LocalDate.parse(this.birthDate, formatter));
        employee.setObservation(this.observation);
        employee.setOccupation(this.occupation);
        employee.setPassword(this.password);
        employee.setAdmin(this.admin);
        employee.setSalary(this.salary);
        employee.setContractStart(LocalDate.parse(this.contractStart, formatter));
        employee.setContractEnd(LocalDate.parse(this.contractEnd, formatter));
        return employee;
    }

}
