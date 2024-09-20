package com.example.service;

import com.example.client.EmployeeServiceClient;
import com.example.client.OrganizationServiceClient;
import com.example.entity.Department;
import com.example.kafka.DepartmentKafkaProducer;
import com.example.repository.DepartmentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class DepartmentService {

    @Inject
    DepartmentRepository departmentRepository;

    @Inject @RestClient
    EmployeeServiceClient employeeService;

    @Inject @RestClient
    OrganizationServiceClient organizationService;

    @Inject
    DepartmentKafkaProducer departmentKafkaProducer;

    public List<Department> getDepartments() {
        return departmentRepository.listAll();
    }

    public List<Department> getDepartmentsByOrganizationId(Long organizationId) {
        return departmentRepository.findDepartmentsByOrganizationId(organizationId);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Department not found with id: " + id, Response.Status.NOT_FOUND));
    }

    public Department getDetailedDepartmentById(Long id) {
        return hydrate(getDepartment(id));
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
        departmentKafkaProducer.emitDeleteDepartmentEvent(id);
        departmentRepository.deleteById(id);
    }

    private Department hydrate(Department department) {
        department.setEmployees(employeeService.getEmployeesByDepartmentId(department.getId()));
        department.setOrganization(organizationService.getOrganizationById(department.getOrganizationId()));
        return department;
    }
}
