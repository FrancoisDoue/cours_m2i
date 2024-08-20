package com.example.scoped;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GlobalRequestCounterService {
    private int globalCounter = 0;

    public int getGlobalCounter() {
        return globalCounter;
    }

    public void increment() {
        globalCounter++;
    }
}
