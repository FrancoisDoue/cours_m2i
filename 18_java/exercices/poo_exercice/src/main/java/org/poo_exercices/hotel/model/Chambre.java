package org.poo_exercices.hotel.model;

public class Chambre {
    private String numero;
    private boolean statut;
    private double tarif;
    private int capacite;

    public Chambre(String numero, double tarif, int capacite) {
        this.numero = numero;
        this.statut = false;
        this.tarif = tarif;
        this.capacite = capacite;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
