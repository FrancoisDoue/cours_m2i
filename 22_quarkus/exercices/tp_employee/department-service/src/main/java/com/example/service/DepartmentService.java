package com.example.service;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class DepartmentService {

    @Inject
    DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        return departmentRepository.listAll();
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Department not found with id: " + id, Response.Status.NOT_FOUND));
    }

    @Transactional
    public Department createDepartment(Department department) {
        departmentRepository.persist(department);
        return department;
    }

    @Transactional
    public Department updateDepartment(Long id, Department department) {
        Department departmentToUpdate = getDepartment(id);
        departmentToUpdate.setName(department.getName());
        departmentToUpdate.setOrganizationId(department.getOrganizationId());
        departmentRepository.persist(departmentToUpdate);
        return department;
    }

    @Transactional
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
