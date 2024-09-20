package com.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class OrganizationKafkaProducer {

    @Inject @Channel("delete-organization-event")
    Emitter<String> deleteOrganizationEvent;

    public void emitDeleteOrganizationEvent(Long organizationId) {
        System.out.println("emit delete organization event | id: " + organizationId);
        String message = String.valueOf(organizationId);
        deleteOrganizationEvent.send(message);
    }
}
