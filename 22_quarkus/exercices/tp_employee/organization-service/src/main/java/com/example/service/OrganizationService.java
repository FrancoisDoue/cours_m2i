package com.example.service;

import com.example.client.EmployeeServiceClient;
import com.example.dto.EmployeeDTO;
import com.example.entity.Organization;
import com.example.kafka.OrganizationKafkaProducer;
import com.example.repository.OrganizationRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class OrganizationService {

    @Inject
    OrganizationRepository organizationRepository;

    @Inject @RestClient
    EmployeeServiceClient employeeService;

    @Inject
    OrganizationKafkaProducer organizationKafkaProducer;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.listAll().stream().map(this::setEmployeesCount).toList();
    }

    public Organization getOrganizationById(Long id) {
        return setEmployeesCount(organizationRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("No organization found with id: " + id, Response.Status.NOT_FOUND)));
    }

    public Organization getDetailedOrganizationById(Long id) {
        return hydrate(getOrganizationById(id));
    }

    @Transactional
    public Organization createOrganization(Organization organization) {
        organizationRepository.persist(organization);
        return organization;
    }

    @Transactional
    public Organization updateOrganization(Long id, Organization organization) {
        Organization organizationToUpdate = getOrganizationById(id);
        organizationToUpdate.setName(organization.getName());
        organizationToUpdate.setAddress(organization.getAddress());
        organizationToUpdate.setEmployeesNumber(organization.getEmployeesNumber());
        organizationToUpdate.setLastEmployeeUpdate(organization.getLastEmployeeUpdate());
        organizationRepository.persist(organizationToUpdate);
        return hydrate(organizationToUpdate);
    }

    @Transactional
    public void deleteOrganization(Long id) {
        organizationKafkaProducer.emitDeleteOrganizationEvent(id);
        organizationRepository.deleteById(id);
    }

    private Organization hydrate(Organization organization) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByOrganizationId(organization.getId());
        organization.setEmployees(employees);
        return setEmployeesCount(organization);
    }

    private Organization setEmployeesCount(Organization organization) {
        Long employeeCount = employeeService.countEmployeesByOrganizationId(organization.getId());
        organization.setEmployeesNumber(employeeCount);
        return organization;
    }

}
