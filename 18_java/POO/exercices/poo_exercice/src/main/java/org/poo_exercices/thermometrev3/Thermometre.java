package org.poo_exercices.thermometrev3;

public class Thermometre {
    public enum Unit {
        KELVIN, FAHRENHEIT, CELSIUS
    }

    private double temperature;
    private Unit unit;

    public Thermometre(double temperature, Unit unit) {
        this.unit = unit;
        setTemperature(temperature);
    }
    public Thermometre() {
        this(.0, Unit.KELVIN);
    }

    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        if (this.unit != Unit.KELVIN) {
            Unit tempUnit = this.unit;
            this.switchToUnit(Unit.KELVIN);
            if (this.temperature < 0){
                this.temperature = 0;
            }
            this.switchToUnit(tempUnit);
            return;
        }
        if (this.temperature < 0) this.temperature = 0;
    }

    public Unit getUnit() {
        return unit;
    }

    public void switchToUnit(Unit unit) {
        this.temperature = switch (this.unit) {
            case KELVIN -> switch (unit){
                case KELVIN -> temperature;
                case FAHRENHEIT -> (temperature - 273.15) * 9/5 + 32;
                case CELSIUS ->  temperature - 273.15;
            };
            case FAHRENHEIT -> switch (unit){
                case FAHRENHEIT -> temperature;
                case KELVIN -> (temperature - 32) * 5/9 + 273.15;
                case CELSIUS -> (temperature - 32) * 5/9;
            };
            case CELSIUS -> switch (unit){
                case KELVIN -> temperature + 273.15;
                case FAHRENHEIT -> (temperature * 9/5) + 32;
                case CELSIUS -> temperature;
            };
        };
        this.unit = unit;
    }

    public String toString() {
        String stringUnit = switch (this.unit){
            case FAHRENHEIT -> "F";
            case KELVIN -> "K";
            case CELSIUS -> "C";
        };
        return temperature+" °"+stringUnit;
    }
}
