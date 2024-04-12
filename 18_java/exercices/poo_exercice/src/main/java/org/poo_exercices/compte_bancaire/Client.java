package org.poo_exercices.compte_bancaire;

import org.poo_exercices.compte_bancaire.comptes.CompteBancaire;

import java.util.ArrayList;
import java.util.List;

public final class Client {
    private final int id;
    private String nom;
    private String prenom;
    private String telephone;
    private List<CompteBancaire> comptesBancaires = new ArrayList<CompteBancaire>();

    private static int nbClients = 0;

    public Client(String nom, String prenom, String telephone) {
        id = ++nbClients;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<CompteBancaire> getComptesBancaires() {
        return comptesBancaires;
    }

    public void addCompteBancaire(CompteBancaire compteBancaire) {
        comptesBancaires.add(compteBancaire);
    }

}
