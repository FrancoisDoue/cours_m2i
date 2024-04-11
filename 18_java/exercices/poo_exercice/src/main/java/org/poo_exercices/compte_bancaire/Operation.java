package org.poo_exercices.compte_bancaire;

public class Operation {
    public enum Type {
        DEPOT, RETRAIT
    }

    private static int nbOperation = 0;

    private final int id;
    private final Type type;
    private final double montant;

    public Operation(Type type, double montant) {
        this.id = ++nbOperation;
        this.type = type;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }
}
