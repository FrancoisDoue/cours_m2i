package com.example.repository;

import com.example.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    public List<Employee> findByOrganizationId(long organizationId) {
        return find("organization_id = :organizationId", organizationId).list();
    }

    public List<Employee> findByDepartmentId(long departmentId) {
        return find("department_id = :departmentId", departmentId).list();
    }
}
