package org.poo_exercices.papeteriev2.model;

public class Stylo extends ArticleUnitaire {
    private final String couleur;

    public Stylo(String nom, double prixUnitaire, String couleur) {
        super(nom, prixUnitaire);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public double getPrix() {
        return this.prixUnitaire;
    }

    @Override
    public String toString() {
        return "Stylo{" +
                "couleur='" + couleur + '\'' +
                ", nom='" + nom + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }
}
