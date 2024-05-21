package org.design_patterns.exercices.exo_06_1_adapter;

public class PaymentAdapter implements OldPaymentGatewayInterface {

    private final NewPaymentProcessor paymentProcessor;

    public PaymentAdapter() {
        paymentProcessor = new NewPaymentProcessor();
    }

    @Override
    public void makePayment(String apiKey, double amount) {
        if (paymentProcessor.authenticate(apiKey))
            paymentProcessor.sendPayement(amount);
    }
}
