package org.poo_exercices.figures.model;

public class Triangle extends Figure {

    private double base;
    private double hauteur;

    public Triangle(double x, double y, double base, double hauteur) {
        super(x, y);
        this.base = base;
        this.hauteur = hauteur;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        double x = origin.getPosX();
        double y = origin.getPosY();
        return String.format("""
                %s %s
                A: %s
                B: %s
                C: %s
                """,
                super.toString(),
                "Base : " + base + " hauteur : " + hauteur,
                x + ";" + y,
                x + ";" + (y + base),
                (x + hauteur) + ";" + (y + (base/2))
                );
    }



}
