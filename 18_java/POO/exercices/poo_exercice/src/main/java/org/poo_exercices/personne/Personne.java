package org.poo_exercices.personne;

public abstract class Personne {


    protected String nom;
    protected String prenom;
    protected String telephone;

    public Personne(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public String toString() {
        return "Nom: " + nom + ", Prenom: " + prenom + ", Telephone: " + telephone + "\n";
    }

//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getPrenom() {
//        return prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }

}
