package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.client.AccountServiceClient;
import org.example.dto.CheckBalanceDto;
import org.example.entity.Payment;
import org.example.kafka.PaymentKafkaProducer;
import org.example.repository.PaymentRepository;

@ApplicationScoped
public class PaymentService {

    @Inject
    PaymentRepository paymentRepository;

    @Inject @RestClient
    AccountServiceClient accountServiceClient;

//    @Inject
//    PaymentKafkaProducer paymentKafkaProducer;

    @Inject @RestClient
    AccountServiceClient accountService;

    @Transactional
    public Payment createPayment(Payment payment) {
        paymentRepository.persist(payment);
        return payment;
    }

    public Payment getPaymentById(long id) {
        return paymentRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));
    }

    public boolean checkBalance(long accountId, double amount) {
        CheckBalanceDto response = accountServiceClient.checkBalance(accountId, amount);
        if (response != null) {
            return response.isCheck();
        }
        return false;
    }

}
