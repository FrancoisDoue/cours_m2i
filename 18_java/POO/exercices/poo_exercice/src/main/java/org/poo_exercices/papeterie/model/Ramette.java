package org.poo_exercices.papeterie.model;


public class Ramette extends ArticleUnitaire {

    private int grammage;

    public Ramette(double prixUnitaire, String nom, int grammage) {
        super(prixUnitaire, nom);
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return super.toString() + "grammage : " + grammage + "g";
    }
}
