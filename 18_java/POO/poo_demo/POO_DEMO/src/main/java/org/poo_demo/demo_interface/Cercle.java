package org.poo_demo.demo_interface;

public class Cercle extends Forme {

    private double rayon;

    public Cercle(String nom, double rayon) {
        super(nom);
        this.rayon = rayon;
    }

    @Override
    public double calulerAire() {
        return Math.pow(Math.PI * rayon, 2);
    }

    @Override
    public double calulerPerimetre() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "rayon= " + rayon +
                ", aire= "+ calulerAire() +
                ", perimetre= "+ calulerPerimetre() +" }";
    }
}
