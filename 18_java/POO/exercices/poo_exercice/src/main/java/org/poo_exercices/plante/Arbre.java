package org.poo_exercices.plante;

public class Arbre extends Plante{

    private double circonferanceTronc;

    public Arbre(String nom, double hauteur, String couleurFeuilles, double circonferanceTronc) {
        super(nom, hauteur, couleurFeuilles);
        this.circonferanceTronc = circonferanceTronc;
    }

    public void setCirconferanceTronc(double circonferanceTronc) {
        this.circonferanceTronc = circonferanceTronc;
    }

    public double getCirconferanceTronc() {
        return circonferanceTronc;
    }

    @Override
    public String toString() {
        return super.toString()+" | circonferanceTronc: " + getCirconferanceTronc() + " cm";
    }
}
