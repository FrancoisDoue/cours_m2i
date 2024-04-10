package org.poo_exercices.thermometrev2;

public class Thermometre {
    public enum Unit {
        KELVIN, FAHRENHEIT, CELSIUS
    }

    private double convertedTemperature;
    private Unit currentUnit;

    private double toKelvin(double t, Unit currentUnit) {
        double newTemperature =  switch (currentUnit) {
            case FAHRENHEIT -> (t - 32) * 5/9 + 273.15;
            case CELSIUS -> t + 273.15;
            default -> t;
        };
        this.currentUnit = Unit.KELVIN;
        return newTemperature;
    }
    public void toKelvin() {
        convertedTemperature = this.toKelvin(convertedTemperature, this.currentUnit);
    }

    private double toCelsius(double t, Unit currentUnit) {
        double newTemperature =  switch (currentUnit) {
            case FAHRENHEIT -> (t - 32) * 5/9;
            case KELVIN -> t - 273.15;
            default -> t;
        };
        this.currentUnit = Unit.CELSIUS;
        return newTemperature;
    }
    public void toCelsius() {
        convertedTemperature = this.toCelsius(convertedTemperature, this.currentUnit);
    }

    private double toFahrenheit(double t, Unit currentUnit) {
        double newTemperature =  switch (currentUnit) {
            case CELSIUS -> t * 9/5 + 32;
            case KELVIN -> (t - 273.15) * 9/5 + 32;
            default -> t;
        };
        this.currentUnit = Unit.FAHRENHEIT;
        return newTemperature;
    }
    public void toFahrenheit() {
        convertedTemperature = this.toFahrenheit(convertedTemperature, this.currentUnit);
    }


    public Thermometre(double temperature, Unit unit){
        this.convertedTemperature = switch (unit) {
            case KELVIN -> toKelvin(temperature, unit);
            case CELSIUS -> toCelsius(temperature, unit);
            case FAHRENHEIT -> toFahrenheit(temperature, unit);
        };
    }
    public Thermometre(){
        this(.0, Unit.KELVIN);
    }

    public double getConvertedTemperature() {
        return convertedTemperature;
    }
    public void setConverterTemperature(double temperature) {
        convertedTemperature = temperature;
    }

    public String toString() {
        String stringUnit = switch (this.currentUnit){
            case FAHRENHEIT -> "F";
            case KELVIN -> "K";
            case CELSIUS -> "C";
        };
        return getConvertedTemperature()+"°"+stringUnit;
    }
}
