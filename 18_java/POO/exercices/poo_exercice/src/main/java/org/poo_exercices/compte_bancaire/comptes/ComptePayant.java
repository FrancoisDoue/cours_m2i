package org.poo_exercices.compte_bancaire.comptes;

import org.poo_exercices.compte_bancaire.Client;

public class ComptePayant extends CompteBancaire{
    public ComptePayant(Client client) {
        super(client);
    }

    @Override
    public String toString() {
        return "Compte payant "+super.toString();
    }
}
