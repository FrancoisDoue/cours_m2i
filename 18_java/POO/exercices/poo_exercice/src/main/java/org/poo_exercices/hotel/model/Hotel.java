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
        clientList.add(client);
    }

    public Client getClientById(int id) throws Exception{
        Client client = clientList.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);
        if (client == null) throw new Exception("Ce client n'existe pas");
        return client;
    }

    public Client getClientByTelephone(String telephone) throws Exception {
        Client client = clientList.stream()
                .filter(c -> c.getTelephone().equals(telephone))
                .findFirst().orElse(null);
        if (client == null) throw new Exception("Ce client n'existe pas");
        return client;
    }

    public void createReservation(Client client, Chambre chambre) {

    }

    public List<Reservation> getReservationsByClientId(int id) throws Exception {
        Client client = getClientById(id);
        return getReservationsByClient(client);
    }
    public List<Reservation> getReservationsByClientTelephone(String telephone) throws Exception {
        Client client = getClientByTelephone(telephone);
        return getReservationsByClient(client);
    }

    private List<Reservation> getReservationsByClient(Client client) {
        return reservationList.stream()
                .filter(r -> r.getClient().equals(client))
                .toList();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
