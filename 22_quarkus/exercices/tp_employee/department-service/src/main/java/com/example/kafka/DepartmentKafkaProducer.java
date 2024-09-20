package com.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class DepartmentKafkaProducer {

    @Inject
    @Channel("delete-department-event")
    Emitter<String> deleteDepartmentEvent;

    public void emitDeleteDepartmentEvent(Long departmentId) {
        System.out.println("on delete department event | id : " + departmentId);
        String message = String.valueOf(departmentId);
        deleteDepartmentEvent.send(message);
    }
}
