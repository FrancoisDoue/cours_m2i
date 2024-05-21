package org.design_patterns.exercices.exo_06_2_adapter.entity;

public interface SmsService {
    void sendSms(String phoneNumber, String message);
}
