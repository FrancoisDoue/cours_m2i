package org.design_patterns.exercices.exo_06_2_adapter;

import org.design_patterns.exercices.exo_06_2_adapter.entity.SmsService;
import org.design_patterns.exercices.exo_06_2_adapter.entity.impl.NotificationAdapter;

public class Main {
    public static void main(String[] args) {

        SmsService notificationAdapter = new NotificationAdapter();
        notificationAdapter.sendSms("012345789", "Hello world!");
    }
}

