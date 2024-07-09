package com.example.ex9_employee_back.repository;

import com.example.ex9_employee_back.entity.Absence;
import com.example.ex9_employee_back.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AbsenceRepository extends CrudRepository<Absence, Integer> {
    List<Absence> findAbsenceByEmployee(Employee employee);
}
