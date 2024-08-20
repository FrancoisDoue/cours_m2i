package com.example.scoped;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestCounterService {
    private int requestCounter = 0;
    public int getRequestCounter() {
        return requestCounter;
    }

    public void increment() {
        requestCounter++;
    }
}
