package org.design_patterns.exercices.exo_06_1_adapter;

public interface OldPaymentGatewayInterface {
    void makePayment(String accountNumber, double amount);
}
