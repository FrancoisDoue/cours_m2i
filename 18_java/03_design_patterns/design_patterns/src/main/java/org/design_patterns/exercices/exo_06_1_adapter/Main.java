package org.design_patterns.exercices.exo_06_1_adapter;

public class Main {
    public static void main(String[] args) {
        OldPaymentGatewayInterface paymentGateway = new PaymentAdapter();
        paymentGateway.makePayment("hello_world", 10.);
    }
}
