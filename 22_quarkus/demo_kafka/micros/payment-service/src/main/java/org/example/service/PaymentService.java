package org.example.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.client.AccountServiceClient;
import org.example.entity.Payment;
import org.example.repository.PaymentRepository;

public class PaymentService {

    @Inject
    PaymentRepository paymentRepository;

    @Inject @RestClient
    AccountServiceClient accountService;

    public Payment createPayment(Payment payment) {
        paymentRepository.persist(payment);
        return payment;
    }

    public Payment getPaymentById(long id) {
        return paymentRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));
    }



}
