package org.poo_exercices.thermometrev3;

public class Main {
    public static void main(String[] args) {
        Thermometre thermometre = new Thermometre();
        System.out.println("thermometre = " + thermometre);
        thermometre.switchToUnit(Thermometre.Unit.CELSIUS);
        thermometre.setTemperature(0);
        System.out.println("thermometre = " + thermometre);
        thermometre.switchToUnit(Thermometre.Unit.FAHRENHEIT);
        System.out.println("thermometre = " + thermometre);
        thermometre.switchToUnit(Thermometre.Unit.KELVIN);
        System.out.println("thermometre = " + thermometre);

        Thermometre tCelsius = new Thermometre(21.5, Thermometre.Unit.CELSIUS);
        System.out.println("tCelsius = " + tCelsius);
    }
}
