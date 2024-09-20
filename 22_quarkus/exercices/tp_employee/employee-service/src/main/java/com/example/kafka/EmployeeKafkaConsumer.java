package com.example.kafka;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.List;

@ApplicationScoped
public class EmployeeKafkaConsumer {

    @Inject
    EmployeeService employeeService;

    @Incoming("delete-organization-event")
    @Transactional
    public void onDeleteOrganization(String message) {
        Long organizationId = Long.parseLong(message);
        List<Employee> employees = employeeService.getEmployeesByOrganizationId(organizationId);
        employees.forEach(employee -> {
            employee.setDepartmentId(null);
            employeeService.updateEmployee(employee.getId(), employee);
            System.out.println("Employee " + employee.getId() + " updated, organizationId set to null");
        });
    }

    @Incoming("delete-department-event")
    @Transactional
    public void onDeleteDepartment(String message) {
        Long departmentId = Long.parseLong(message);
        List<Employee> employees = employeeService.getEmployeesByDepartmentId(departmentId);
        employees.forEach(employee -> {
            employee.setDepartmentId(null);
            employeeService.updateEmployee(employee.getId(), employee);
            System.out.println("Employee " + employee.getId() + " updated, departmentId set to null");
        });
    }
}
