package com.example.repository;

import com.example.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    public List<Employee> findByOrganizationId(Long organizationId) {
        if (organizationId == null) return find("organizationId is null").list();
        return find("organizationId = ?1", organizationId).list();
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        if (departmentId == null) return find("departmentId is null").list();
        return find("departmentId = ?1", departmentId).list();
    }

    public Long countByOrganizationId(Long organizationId) {
        return count("organizationId = ?1", organizationId);
    }
}
