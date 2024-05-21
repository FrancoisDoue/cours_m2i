package org.poo_exercices.compte_bancaire.comptes;

import org.poo_exercices.compte_bancaire.Client;
import org.poo_exercices.compte_bancaire.Operation;

public class CompteEpargne extends CompteBancaire{

    private final double tauxInteret = .005;

    public CompteEpargne(Client client) {
        super(client);
    }

    @Override
    public boolean addOperation(Operation operation) {
        boolean initialBool = super.addOperation(operation);
        if(initialBool && operation.getType() == Operation.Type.DEPOT) {
            Operation interet = new Operation(Operation.Type.INTERET, tauxInteret);
            boolean successOperation = setSolde(solde * tauxInteret);
            interet.setStatus(successOperation);
            operations.add(interet);
            return successOperation;
        }
        return initialBool;
    }

    @Override
    public String toString() {
        return "Compte épargne "+super.toString();
    }
}
