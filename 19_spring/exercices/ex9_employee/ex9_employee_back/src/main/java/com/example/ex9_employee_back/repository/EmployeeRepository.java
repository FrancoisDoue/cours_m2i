package com.example.ex9_employee_back.repository;

import com.example.ex9_employee_back.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
