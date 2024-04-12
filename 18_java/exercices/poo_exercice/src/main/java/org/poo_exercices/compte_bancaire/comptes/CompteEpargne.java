package org.poo_exercices.compte_bancaire.comptes;

import org.poo_exercices.compte_bancaire.Client;

public class CompteEpargne extends CompteBancaire{
    public CompteEpargne(Client client) {
        super(client);
    }

    @Override
    public String toString() {
        return "Compte épargne "+super.toString();
    }
}
