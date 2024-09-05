package com.example.repository;

import com.example.model.Employee;

import java.util.List;

public class EmployeeRepository extends BaseRepository<Employee> {
    @Override
    public Employee get(int id) {
        _session = _factory.openSession();
        Employee employee = _session.get(Employee.class, id);
        _session.close();
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        _session = _factory.openSession();
        List<Employee> employees = _session.createQuery("from Employee" ,Employee.class).list();
        _session.close();
        return employees;
    }
}
