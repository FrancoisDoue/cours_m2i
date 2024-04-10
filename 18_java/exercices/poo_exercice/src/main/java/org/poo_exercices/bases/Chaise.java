package org.poo_exercices.bases;

public class Chaise {

    // la variable devient non modifiable sauf dans le constructeur
    private final int pieds;
    private String matiere;
    private String couleur;
    private double prix;

    public Chaise() {
        this(4, "Chaîne", "Bleu", 14.4);
    }

    public Chaise(int pieds, String matiere, String couleur, double prix) {
        this.pieds = pieds;
        this.matiere = matiere;
        this.couleur = couleur;
        this.prix = prix;
    }

    public String toString() {
        return "Je suis une chaise avec " + pieds + " pieds(s) en " + matiere + " de couleur " + couleur + " à un prix de " + prix + "€";
    }

}
