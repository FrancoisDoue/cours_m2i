package org.poo_exercices.compte_bancaire;

import java.util.List;

public final class Client {
    // TODO : tout.
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private static int nbClients = 0;
    private List<CompteBancaire> comptesBancaire;

    public Client(String nom, String prenom, String telephone) {
        id = ++nbClients;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
