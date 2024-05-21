package org.poo_exercices.papeterie.model;

public class Stylo extends ArticleUnitaire{

    private String couleur;

    public Stylo(double prixUnitaire, String nom, String couleur) {
        super(prixUnitaire, nom);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return super.toString()+ "couleur : " +getCouleur()+ " ";
    }
}
