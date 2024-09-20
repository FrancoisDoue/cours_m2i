package com.example.kafka;

import com.example.entity.Department;
import com.example.service.DepartmentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.List;

@ApplicationScoped
public class DepartmentKafkaConsumer {

    @Inject
    DepartmentService departmentService;

    @Incoming("delete-organization-event")
    @Transactional
    public void onDeleteOrganization(String message) {
        Long organizationId = Long.parseLong(message);
        List<Department> departments = departmentService.getDepartmentsByOrganizationId(organizationId);
        departments.forEach(department -> {
            department.setOrganizationId(null);
            departmentService.updateDepartment(department.getId(), department);
            System.out.println("department "+ department.getId() + " updated");
        });
    }
}
