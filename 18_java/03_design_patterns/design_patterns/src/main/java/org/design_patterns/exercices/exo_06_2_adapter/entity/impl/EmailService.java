package org.design_patterns.exercices.exo_06_2_adapter.entity.impl;

public class EmailService {

    public void sendEmail(String email, String subject, String body) {
        System.out.println("Sending email to " + email
                + ((subject == null) ? "" : "\nSubject: " + subject)
                + "\nBody: " + body);
    }
}
