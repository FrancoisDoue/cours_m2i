package org.poo_exercices.compte_bancaire.comptes;

import org.poo_exercices.compte_bancaire.Client;
import org.poo_exercices.compte_bancaire.Operation;

public class CompteCourant extends CompteBancaire {

    private double decouvert = -100;
    private final double frais = .002;

    public CompteCourant(Client client) {
        super(client);
    }

    @Override
    public String toString() {
        return "Compte courant " + super.toString();
    }

    @Override
    public boolean addOperation(Operation operation) {
        boolean initialBool = super.addOperation(operation);
        if (initialBool && operation.getType() != Operation.Type.FRAIS) {
            Operation frais = new Operation(Operation.Type.FRAIS, this.frais);
            boolean successOperation = setSolde(solde * (-this.frais));
            frais.setStatus(successOperation);
            operations.add(frais);
            return successOperation;
        }
        return initialBool;
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
