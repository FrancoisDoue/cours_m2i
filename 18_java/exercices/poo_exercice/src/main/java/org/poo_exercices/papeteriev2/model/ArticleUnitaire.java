package org.poo_exercices.papeteriev2.model;

public abstract class ArticleUnitaire extends Article {

    protected String nom;
    protected double prixUnitaire;

    public ArticleUnitaire(String nom, double prixUnitaire) {
        super();
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }
}
