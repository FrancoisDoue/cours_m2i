package org.example.kafka;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.example.entity.Payment;
import org.example.service.PaymentService;
import org.example.util.constant.PaymentStatus;

@ApplicationScoped
public class PaymentKafkaConsumer {

    @Inject
    PaymentService paymentService;

    @Inject
    PaymentKafkaProducer paymentKafkaProducer;

    @Incoming("created-order-event")
    @Blocking
    public void onCreatedOrderEvent(String message) {
        System.out.println("On Created Order Event: " + message);
        String[] explodedMessage = message.split(" ");
        long orderId = Long.parseLong(explodedMessage[0]);
        long accountId = Long.parseLong(explodedMessage[1]);
        float amount = Float.parseFloat(explodedMessage[2]);
        boolean balancedCheck = paymentService.checkBalance(accountId, amount);
        paymentService.createPayment(
                new Payment(0, orderId, amount, (balancedCheck ? PaymentStatus.ACCEPTED : PaymentStatus.REFUSED))
        );
        paymentKafkaProducer.sendCheckBalanceEvent(orderId, balancedCheck);
    }
}
