package com.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class EmployeeKafkaProducer {

    @Inject @Channel("change-employee-event")
    Emitter<String> changeEmployeeEvent;

    public void emitChangeEmployeeEvent(Long organizationId) {
        System.out.println("emit change employee event for organization " + organizationId);
        changeEmployeeEvent.send(organizationId.toString());
    }
}
