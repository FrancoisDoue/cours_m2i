package org.poo_exercices.thermometre;

public class Thermometre {
    private double temperature;

    public enum Unit {
        KELVIN,
        CELSIUS,
        FAHRENHEIT,
    }

    public Thermometre (double temperature, Thermometre.Unit unit) {
        this.temperature = convert(temperature, unit);
    }

    private double convert(double temp, Thermometre.Unit unit) {
        switch (unit) {
            case CELSIUS:
                temperature = (temp - 273.15);
                break;
            case FAHRENHEIT:
                temperature = (temp - 273.15) * 9/5 + 32;
                break;
            default:
                temperature = temp;
                break;
        }
        return temperature;
    }
    public double convert (Thermometre.Unit unit) {
        return this.convert(temperature, unit);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
