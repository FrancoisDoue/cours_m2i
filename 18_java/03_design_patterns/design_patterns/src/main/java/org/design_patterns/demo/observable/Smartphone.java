package org.design_patterns.demo.observable;

public class Smartphone implements Observer{

    @Override
    public void update(Weather weather) {
        System.out.println("weather from " + getClass().getSimpleName() + " = " + weather.temperature);
    }
}
