package org.poo_exercices.papeterie.model;

public abstract class ArticleUnitaire extends Article {
    protected String nom;
    protected double prixUnitaire;

    public ArticleUnitaire(double prixUnitaire, String nom) {
        super();
        this.prixUnitaire = prixUnitaire;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    @Override
    public double getPrix() {
        return prixUnitaire;
    }

    @Override
    public String toString() {
        return super.toString()+ ", prix unitaire :" +prixUnitaire+"€, Libelle "+nom+", ";
    }
}
