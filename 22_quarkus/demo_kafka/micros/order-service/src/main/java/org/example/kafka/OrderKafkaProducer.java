package org.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class OrderKafkaProducer {

    @Inject
    @Channel("created-order-event")
    Emitter<String> orderEventEmitter;

//    @Transactional
    public void emitCreatedOrderEvent(long idOrder, long idClient, double price) {
        System.out.println("I'm here!");
        String message = idOrder + " " + idClient + " " + price;
        try {
            orderEventEmitter.send(message).toCompletableFuture().get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}
