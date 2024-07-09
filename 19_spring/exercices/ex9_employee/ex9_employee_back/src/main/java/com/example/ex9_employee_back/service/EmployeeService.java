package com.example.ex9_employee_back.service;

import com.example.ex9_employee_back.dto.absence.AbsencePostDTO;
import com.example.ex9_employee_back.dto.employee.EmployeePostDTO;
import com.example.ex9_employee_back.entity.Employee;
import com.example.ex9_employee_back.exception.NotFoundException;
import com.example.ex9_employee_back.repository.AbsenceRepository;
import com.example.ex9_employee_back.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AbsenceRepository absenceRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AbsenceRepository absenceRepository) {
        this.employeeRepository = employeeRepository;
        this.absenceRepository = absenceRepository;
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
        throw new UnsupportedOperationException("Not supported yet.");
//        Employee employee = getEmployeeById(employeeId);
    }
}
