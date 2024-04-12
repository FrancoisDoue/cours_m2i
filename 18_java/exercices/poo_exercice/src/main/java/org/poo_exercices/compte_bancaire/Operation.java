package org.poo_exercices.compte_bancaire;

public class Operation {

    public enum Type {
        DEPOT, RETRAIT, INTERET, FRAIS
    }

    private static int nbOperation = 0;

    private final int id;
    private final Type type;
    private final double montant;
    private boolean status = false;

    public Operation(Type type, double montant) {
        this.id = ++nbOperation;
        this.type = type;
        this.montant = montant;
    }

    public Type getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        String description = switch (type) {
            case DEPOT ->
                    " [ Dépot " + id + ", montant : + " + montant + " ]\u001B[0m";
            case RETRAIT ->
                    " [ Retrait " + id + ", montant : - " + montant + " ]\u001B[0m";
            case INTERET ->
                    " [ Interêt " + id + ", taux : +" + (montant*100) + "% ]\u001B[0m";
            case FRAIS ->
                    " [ Frais " + id + ", taux : -" + (montant*100) + "% ]\u001B[0m";
        };
        return (status ? "\u001B[32mApprouvé :" : "\u001B[31mRejeté :") + description;
    }
}
