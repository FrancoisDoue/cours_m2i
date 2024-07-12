package com.example.ex9_employee_back.service;

import com.example.ex9_employee_back.dto.auth.AuthPostDTO;
import com.example.ex9_employee_back.dto.employee.EmployeeGetDTO;
import com.example.ex9_employee_back.entity.Employee;
import com.example.ex9_employee_back.exception.AuthenticationFailedException;
import com.example.ex9_employee_back.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public AuthService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeGetDTO login(AuthPostDTO authPost) {
        Employee employee = employeeRepository.findEmployeeByEmail(authPost.getEmail())
                .orElseThrow(() -> new AuthenticationFailedException("invalid credentials"));
        if (!employee.getPassword().equals(authPost.getPassword()))
            throw new AuthenticationFailedException("invalid credentials");
        return new EmployeeGetDTO(employee);
    }
}
