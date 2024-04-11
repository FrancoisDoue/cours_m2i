package org.poo_exercices.plante;

public class Plante {
    protected String nom;
    protected double hauteur;
    protected String couleurFeuilles;

    public Plante(String nom, double hauteur, String couleurFeuilles) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleurFeuilles = couleurFeuilles;
    }

    public Plante(){
        this("Geranium", 30, "vertes");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleurFeuilles() {
        return couleurFeuilles;
    }

    public void setCouleurFeuilles(String couleurFeuilles) {
        this.couleurFeuilles = couleurFeuilles;
    }

    public String toString(){
        return getClass().getSimpleName() + " =>  nom: "
            + getNom() + " | hauteur: "+ getHauteur()
            + " cm | couleurFeuilles: " + getCouleurFeuilles();
    }
}
