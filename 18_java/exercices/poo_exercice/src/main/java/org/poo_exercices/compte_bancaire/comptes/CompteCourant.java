package org.poo_exercices.compte_bancaire.comptes;

import org.poo_exercices.compte_bancaire.Client;

public class CompteCourant extends CompteBancaire {

    private double decouvert = -100;

    public CompteCourant(Client client) {
        super(client);
    }

    @Override
    public String toString() {
        return "Compte courant " + super.toString();
    }

    @Override
    public boolean setSolde(double solde) {
        double tempSolde = this.solde + solde;
        if (tempSolde < decouvert)
            return false;
        this.solde = tempSolde;
        return true;
    }

}
