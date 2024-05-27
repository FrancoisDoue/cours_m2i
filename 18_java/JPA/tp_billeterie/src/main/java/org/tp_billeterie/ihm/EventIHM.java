package org.tp_billeterie.ihm;

import org.tp_billeterie.entity.Event;
import org.tp_billeterie.entity.Ticket;
import org.tp_billeterie.repository.impl.EventRepository;
import org.tp_billeterie.repository.impl.TicketRepository;
import org.tp_billeterie.util.DatabaseManager;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EventIHM {

    EventRepository eRepository = new EventRepository();
    AddressIHM addressIHM = new AddressIHM();
    TicketRepository ticketRepository = new TicketRepository();

    public void start() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    1. Afficher les évènements
                    2. Créer un nouvel évènement
                    3. Editer un évènement
                    4. Annuler un évènement
                    5. Gestion des adresses
                    [0] Retour au menu précédent
                    """);
            try {
                switch (sc.nextInt()) {
                    case 1 -> eRepository.getAll().forEach(System.out::println);
                    case 2 -> createEventMenu();
                    case 3 -> {}
                    case 4 -> {}
                    case 5 -> {}
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

    public void createEventMenu() {
        Scanner sc = new Scanner(System.in);
        Event event = new Event();
        System.out.println(" - - - Créer un évènement");
        System.out.println("Nom de l'évènement");
        event.setName(sc.nextLine());
        System.out.println(addressIHM.showLocations());
        System.out.println("Sélectionner une Salle? [y/n]");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            event.setLocation(addressIHM.selectLocation());
        } else {
            event.setLocation(addressIHM.createLocation());
        }
        System.out.println("Mois:");
        int month = sc.nextInt();
        sc.nextLine();
        System.out.println("jour:");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Heure:");
        int hour = sc.nextInt();
        sc.nextLine();
        System.out.println("Minutes:");
        int minuts = sc.nextInt();
        sc.nextLine();
        event.setEventDate(LocalDate.of(LocalDate.now().getYear(), month, day));
        event.setEventTime(LocalTime.of(hour, minuts));
        System.out.println("Nombre de places (max " + event.getLocation().getCapacity() + ") :");
        int maxCapacity = sc.nextInt();
        sc.nextLine();
        if (maxCapacity > event.getLocation().getCapacity())
            maxCapacity = event.getLocation().getCapacity();
        event.setMaxCapacity(maxCapacity);
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < maxCapacity; i++) {
            tickets.add(Ticket.builder().ticketType(1).event(event).build());
        }
        eRepository.save(event);
        ticketRepository.saveMany(tickets);
        event.setTickets(tickets);

    }

}
