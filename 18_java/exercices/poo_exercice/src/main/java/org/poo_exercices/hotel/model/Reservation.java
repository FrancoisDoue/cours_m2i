package org.poo_exercices.hotel.model;

public class Reservation {
    private static int nbReservation = 0;
    private int numero;
    private boolean statut;
    private Client client;
    private Chambre chambre;

    public Reservation(boolean statut, Client client, Chambre chambre) {
        this.numero = ++nbReservation;
        this.statut = statut;
        this.client = client;
        this.chambre = chambre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}
