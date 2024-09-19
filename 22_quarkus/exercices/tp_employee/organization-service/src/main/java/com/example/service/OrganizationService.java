package com.example.service;

import com.example.entity.Organization;
import com.example.repository.OrganizationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class OrganizationService {

    @Inject
    OrganizationRepository organizationRepository;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.listAll();
    }

    public Organization getOrganizationById(Long id) {
        return organizationRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("No organization found with id: " + id, Response.Status.NOT_FOUND));
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
        return organizationToUpdate;
    }

    @Transactional
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }


}
