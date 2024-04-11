package org.poo_demo.heritage;

public class Chat extends Felin{
    private String nom;

    public Chat(int age, String espece, String nom) {
        super(age, espece);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
