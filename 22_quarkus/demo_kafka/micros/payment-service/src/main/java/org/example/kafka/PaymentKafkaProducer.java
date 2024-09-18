package org.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class PaymentKafkaProducer {

    @Inject
    @Channel("check-balance")
    Emitter<String> checkBalanceEmitter;

    public void sendCheckBalanceEvent(int idClient, boolean check) {
        String message = idClient + " " + (check ? "1" : "0");
        checkBalanceEmitter.send(message);
    }
}
