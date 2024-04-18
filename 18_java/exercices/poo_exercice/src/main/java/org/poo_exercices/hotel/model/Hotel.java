package org.poo_exercices.hotel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hotel {
    private static Hotel INSTANCE;
    private String nom;
    private List<Chambre> chambreList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();
    private List<Reservation> reservationList = new ArrayList<>();

    public static Hotel getInstance(String nom) {
        if (INSTANCE == null) INSTANCE = new Hotel(nom);
        return INSTANCE;
    }

    private Hotel(String nom) {
        this.nom = nom;
        for (int i = 1; i < 21; i++) {
            Random random = new Random();
            String n = ((i < 10) ? "00" : "0") + 1;
            this.chambreList.add(
                    new Chambre(n+i, 1.*random.nextInt(50,200), random.nextInt(1,3))
            );
        }
    }

    public void addClient(Client client) {
        if (! clientList.contains(client))
            clientList.add(client);
    }

    public void createReservation(Client client, Chambre chambre) {

    }

    public String getNom() {
        return nom;
    }

    public List<Chambre> getChambreList() {
        return chambreList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

}
