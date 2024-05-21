package org.poo_exercices.thermometre;

public class Main {
    public static void main(String[] args) {
        Thermometre kelvin = new Thermometre(200, Thermometre.Unit.KELVIN);
        System.out.println("kelvin.getTemperature() = " + kelvin.getTemperature());

        Thermometre fahrenheit = new Thermometre(300, Thermometre.Unit.FAHRENHEIT);
        System.out.println("fahrenheit.getTemperature() = " + fahrenheit.getTemperature());

        Thermometre celsius = new Thermometre(500, Thermometre.Unit.CELSIUS);
        System.out.println("celsius.getTemperature() = " + celsius.getTemperature());

        Thermometre temp = new Thermometre(0, Thermometre.Unit.KELVIN);
        System.out.println("t Kelvin = " + temp.getTemperature());
        temp.setTemperature(300);
        System.out.println("ajouter 300 ° " + temp.getTemperature());
        System.out.println("Puis simple conversion en fahrenheit = " + temp.convert(Thermometre.Unit.FAHRENHEIT));


    }
}
