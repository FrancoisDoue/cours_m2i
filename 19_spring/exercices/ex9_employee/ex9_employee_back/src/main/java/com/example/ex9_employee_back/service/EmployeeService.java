package com.example.ex9_employee_back.service;

import com.example.ex9_employee_back.dto.absence.AbsencePostDTO;
import com.example.ex9_employee_back.dto.employee.EmployeePostDTO;
import com.example.ex9_employee_back.dto.recruitment.RecruitmentPostDTO;
import com.example.ex9_employee_back.entity.Absence;
import com.example.ex9_employee_back.entity.Candidate;
import com.example.ex9_employee_back.entity.Employee;
import com.example.ex9_employee_back.exception.FailedConversionException;
import com.example.ex9_employee_back.exception.NotFoundException;
import com.example.ex9_employee_back.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CandidateService candidateService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CandidateService candidateService) {
        this.employeeRepository = employeeRepository;
        this.candidateService = candidateService;
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
    }

    public Employee createEmployee(EmployeePostDTO employeePost) {
        return employeeRepository.save(employeePost.toEntity());
    }

    public Employee updateEmployee(int id, EmployeePostDTO employeePost) {
        if (!employeeRepository.existsById(id)) throw new NotFoundException("Employee not found");
        Employee employeeToUpdate = employeePost.toEntity();
        employeeToUpdate.setId(id);
        return employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) throw new NotFoundException("Employee not found");
        employeeRepository.deleteById(id);
    }

    public Employee addAbsenceToEmployee(int employeeId, AbsencePostDTO absencePost) {
        Employee employee = getEmployeeById(employeeId);
        Absence absence = absencePost.toEntity();
        absence.setEmployee(employee);
        employee.getAbsences().add(absence);
        return employeeRepository.save(employee);
    }

    public Employee recruitCandidate(int candidateId, RecruitmentPostDTO recruitmentPost) {
//        Candidate candidate = candidateService.getCandidateById(candidateId);
//        try {
//            Employee employee = Employee.builder()
//                    .firstname(candidate.getFirstname())
//                    .lastname(candidate.getLastname())
//                    .identificationNumber(candidate.getIdentificationNumber())
//                    .phone(candidate.getPhone())
//                    .address(candidate.getAddress())
//                    .email(candidate.getEmail())
//                    .birthDate(candidate.getBirthDate())
//                    .observation(candidate.getObservation())
//                    .contractStart(recruitmentPost.getContractStart())
//                    .contractEnd(recruitmentPost.getContractEnd())
//                    .password(recruitmentPost.getPassword())
//                    .observation(recruitmentPost.getOccupation())
//                    .salary(recruitmentPost.getSalary())
//                    .build();
//            employeeRepository.save(employee);
//            candidateService.deleteCandidateById(candidateId);
//            return employee;
//        } catch (Exception e) {
//            throw new FailedConversionException("Error occurred while conversion");
//        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
