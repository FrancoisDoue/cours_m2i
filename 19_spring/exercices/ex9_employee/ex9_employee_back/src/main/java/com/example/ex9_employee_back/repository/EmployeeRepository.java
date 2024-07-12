package com.example.ex9_employee_back.repository;

import com.example.ex9_employee_back.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Optional<Employee> findEmployeeByEmail(String email);
}
