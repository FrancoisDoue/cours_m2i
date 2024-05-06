package org.design_patterns.exercices.exo_06_1_adapter;

public class NewPaymentProcessor {

    public boolean authenticate(String apiKey) {
        return true;
    }

    public void sendPayement(double amount) {
        System.out.println("NEW payment gateway ok");
    }

}
