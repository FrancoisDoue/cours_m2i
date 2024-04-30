package org.design_patterns.demo.observable;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.notifyObservers();
        station.registerObserver(new Smartphone());
        station.notifyObservers();

    }
}
