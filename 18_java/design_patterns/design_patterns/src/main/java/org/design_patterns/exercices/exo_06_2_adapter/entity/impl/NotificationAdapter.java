package org.design_patterns.exercices.exo_06_2_adapter.entity.impl;

import org.design_patterns.exercices.exo_06_2_adapter.entity.SmsService;

public class NotificationAdapter implements SmsService {

    EmailService emailService;

    public NotificationAdapter() {
        emailService = new EmailService();
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        emailService.sendEmail(getEmailByPhoneNumber(phoneNumber), null, message);
    }

    public String getEmailByPhoneNumber(String phoneNumber) {
        return "ok."+phoneNumber+"@gmail.com";
    }
}
