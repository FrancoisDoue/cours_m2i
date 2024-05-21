package org.poo_demo.demo_interface;

public class Rectangle extends Forme {

    private double longueur;
    private double largeur;

    public Rectangle(String nom, double longueur, double largeur) {
        super(nom);
        this.longueur = longueur;
        this.largeur = largeur;
    }


    @Override
    public double calulerAire() {
        return longueur*largeur;
    }

    @Override
    public double calulerPerimetre() {
        return (longueur + largeur) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                ", perimetre = "+ calulerPerimetre() +
                ", aire= "+ calulerAire() +"}";
    }
}
