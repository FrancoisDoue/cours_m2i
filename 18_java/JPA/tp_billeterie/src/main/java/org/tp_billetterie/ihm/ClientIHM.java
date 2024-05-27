package org.tp_billetterie.ihm;

import org.tp_billetterie.entity.Client;
import org.tp_billetterie.entity.Event;
import org.tp_billetterie.entity.Ticket;
import org.tp_billetterie.repository.impl.ClientRepository;
import org.tp_billetterie.repository.impl.EventRepository;
import org.tp_billetterie.repository.impl.TicketRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientIHM {
    ClientRepository cRepository = new ClientRepository();

    public void start() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    1. Afficher les clients
                    2. Ajouter un nouveau client
                    3. Modifier un client
                    4. Supprimer un client (L'Agent 47 approuve)
                    5. Inscrire un client à un évènement
                    [0] Quitter
                    """);
            try {
                switch (sc.nextInt()) {
                    case 1 -> cRepository.getAll().forEach(System.out::println);
                    case 2 -> createClientMenu();
                    case 3 -> updateClient();
                    case 4 -> deleteClient();
                    case 5 -> registerClientToEvent();
                    case 0 -> {
                        return;
                    }
                    default -> throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Saisie invalide");
            }
        }
    }

    public void createClientMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" - - - Ajouter un client - - -");
        createClient(new Client());
//        Client client = new Client();
//        System.out.println("Nom du client : ");
//        client.setLastname(sc.nextLine());
//        System.out.println("Prénom du client : ");
//        client.setFirstname(sc.nextLine());
//        System.out.println("Numéro de téléphone: ");
//        client.setPhoneNumber(sc.nextLine());
//        client.setAddress(new AddressIHM().createAddress());
//        cRepository.save(client);
    }

    public void createClient(Client client){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom du client : ");
        client.setLastname(sc.nextLine());
        System.out.println("Prénom du client : ");
        client.setFirstname(sc.nextLine());
        System.out.println("Numéro de téléphone: ");
        client.setPhoneNumber(sc.nextLine());
        if (client.getAddress() != null) {
            client.setAddress(new AddressIHM().updateAddress(client.getAddress()));
        } else {
            client.setAddress(new AddressIHM().createAddress());
        }
        cRepository.save(client);
    }

    public void updateClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" - - - Modifier les informations d'un client");
        Client client = selectClient();
        System.out.println(client);
        createClient(client);
    }

    public Client selectClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" - - - Sélectionner un client - - -");
        cRepository.getAll().forEach(System.out::println);
        System.out.println(" -  Sélectionnez l'identifiant client");
        return cRepository.getById(sc.nextInt());
    }

    public void deleteClient() {
        Scanner sc = new Scanner(System.in);
        Client client = selectClient();
        System.out.println("Voulez vous vraiment supprimer " + client.getFirstname() + " " + client.getLastname() + " [y/n]");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            cRepository.delete(client);
            System.out.println("Client supprimé");
        } else {
            System.out.println("Suppression annulée");
        }
    }

    public void registerClientToEvent() {
        Client client = selectClient();
        Scanner sc = new Scanner(System.in);
        EventRepository eventRepository = new EventRepository();
        eventRepository.getAll().forEach(System.out::println);
        System.out.println(" - Sélectionnez l'identifiant de l'évènement:");
        Event event = eventRepository.getById(sc.nextInt());
        List<Ticket> availableTickets = event.getTickets().stream()
                .filter(t -> t.getClient() == null).toList();
        availableTickets.forEach(System.out::println);
        System.out.println("Sélectionnez l'identifiant du billet : ");
        int id = sc.nextInt();
        for (Ticket ticket : availableTickets) {
            if (ticket.getId() == id) {
                ticket.setClient(client);
                new TicketRepository().update(ticket);
                return;
            }
        }
        System.out.println("Ticket introuvable");

    }
}
