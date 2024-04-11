package org.poo_exercices.compte_bancaire;

public abstract class CompteBancaire {

    protected double solde = 0;
    protected Client client;
    protected Operation[] operations = new Operation[1000];

    public CompteBancaire(double solde, Client client) {
        this.client = client;
    }

    public CompteBancaire(Client client) {
        this.client = client;
        solde = 0;
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }
}
