package com.example.service;

import com.example.client.DepartmentServiceClient;
import com.example.client.OrganizationServiceClient;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    @Inject @RestClient
    DepartmentServiceClient departmentService;

    @Inject @RestClient
    OrganizationServiceClient organizationService;

    public List<Employee> getAllEmployees() {
        return employeeRepository.listAll();
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> getEmployeesByOrganizationId(Long organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Employee not found with id " + id, Response.Status.NOT_FOUND));
    }

    public Employee getDetailedEmployeeById(Long id) {
        return hydrate(getEmployeeById(id));
    }

    public Long countEmployeesByOrganizationId(Long organizationId) {
        return employeeRepository.countByOrganizationId(organizationId);
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        employeeRepository.persist(employee);
        return employee;
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = getEmployeeById(id);
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setPosition(employee.getPosition());
        employeeToUpdate.setDepartmentId(employee.getDepartmentId());
        employeeToUpdate.setOrganizationId(employee.getOrganizationId());
        employeeRepository.persist(employeeToUpdate);
        return employee;
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.delete(getEmployeeById(id));
    }

    public Employee hydrate(Employee employee) {
        employee.setDepartment(departmentService.getDepartmentById(employee.getDepartmentId()));
        employee.setOrganization(organizationService.getOrganizationById(employee.getOrganizationId()));
        return employee;
    }

}
