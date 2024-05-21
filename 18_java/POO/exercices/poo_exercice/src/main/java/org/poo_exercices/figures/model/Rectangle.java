package org.poo_exercices.figures.model;

public class Rectangle extends Figure {
    private double longueur;
    private double largeur;

    public Rectangle(double x, double y, double longueur, double largeur) {
        super(x, y);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
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
                D: %s
                """,
                super.toString(),
                "longueur: " + longueur + ", largeur : " + largeur,
                x + ";" + y,
                x + ";" + (y+largeur),
                (x+longueur) + ";" + (y+largeur),
                (x+longueur) + ";" + y
                );
    }
}
