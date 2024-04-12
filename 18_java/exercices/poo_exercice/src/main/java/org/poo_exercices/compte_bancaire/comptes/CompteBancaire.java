package org.poo_exercices.compte_bancaire.comptes;

import org.poo_exercices.compte_bancaire.Client;
import org.poo_exercices.compte_bancaire.Operation;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {

    protected final int id;
    protected double solde = 0;
    protected Client client;

    protected List<Operation> operations = new ArrayList<Operation>();

    private static int nbCompteBancaire = 0;

    public CompteBancaire(Client client) {
        this.client = client;
        this.id = ++nbCompteBancaire;
        this.client.addCompteBancaire(this);
    }

    public int getId() {
        return id;
    }

    public double getSolde() {
        return solde;
    }

    public boolean setSolde(double solde) {
        double tempSolde = this.solde + solde;
        if (tempSolde < 0)
            return false;
        this.solde = (double) Math.round(tempSolde * 100) /100;
        return true;
    }

    public boolean addOperation(Operation operation) {
        double amount = switch (operation.getType()) {
            case DEPOT, INTERET -> operation.getMontant();
            case RETRAIT, FRAIS -> -operation.getMontant();
        };
        boolean operationSuccess = setSolde(amount);
        operation.setStatus(operationSuccess);
        operations.add(operation);
        return operationSuccess;
    }

    public List<Operation> getOperations() {
        return operations;
    }


    public String toString() {
        return "id. " + id + " -> Solde disponible: " + solde + " €";
    }
}
