package com.example.repository;

import com.example.entity.Department;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class DepartmentRepository implements PanacheRepository<Department> {

    public List<Department> findDepartmentsByOrganizationId(Long organizationId) {
        return find("organizationId = ?1", organizationId).list();
    }
}
