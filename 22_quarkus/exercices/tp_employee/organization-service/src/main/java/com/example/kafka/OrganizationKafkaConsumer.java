package com.example.kafka;

import com.example.entity.Organization;
import com.example.service.OrganizationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.time.LocalDate;

@ApplicationScoped
public class OrganizationKafkaConsumer {

    @Inject
    OrganizationService organizationService;

    @Incoming("change-employee-event")
    @Transactional
    public void onChangeEmployeeEvent(String message) {
        try {
            Long id = Long.parseLong(message);
            Organization organization = organizationService.getOrganizationById(id);
            organization.setLastEmployeeUpdate(LocalDate.now());
            organizationService.updateOrganization(organization.getId(), organization);
            System.out.println("Organization "+ organization.getId() +" updated , last employee updated at " + organization.getLastEmployeeUpdate());
        } catch (WebApplicationException e) {
            System.out.println(e.getMessage());
        }
    }
}
