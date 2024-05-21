package org.design_patterns.exercices.exo_06_1_adapter;

public class OldPaymentGateway {

    public void makePayment(String accountNumber, double amount) {
        System.out.println("OLD payment gateway ok");
    }
}
