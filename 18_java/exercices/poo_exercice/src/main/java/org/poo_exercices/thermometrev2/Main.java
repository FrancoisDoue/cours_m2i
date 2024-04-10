package org.poo_exercices.thermometrev2;

public class Main {
    public static void main(String[] args) {
        Thermometre temperature = new Thermometre(30, Thermometre.Unit.CELSIUS);
        System.out.println("temperature = " + temperature);
        temperature.toFahrenheit();
        System.out.println("temperature = " + temperature);
        temperature.toKelvin();
        System.out.println("temperature = " + temperature);

        Thermometre tMoyEspace = new Thermometre(1.15, Thermometre.Unit.KELVIN);
        tMoyEspace.toCelsius();
        System.out.println("tMoyFondDifus = " + tMoyEspace);
    }
}
