package org.tp_billeterie.ihm;

import org.tp_billeterie.entity.Event;
import org.tp_billeterie.entity.Location;
import org.tp_billeterie.repository.impl.EventRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventIHM {

    EventRepository eRepository = new EventRepository();

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
        System.out.println("Non implémenté");
//        Scanner sc = new Scanner(System.in);
//        System.out.println(" - - - Créer un évènement");
//        Event event = new Event();
//        System.out.println("Nom de l'évènement");
//        event.setName(sc.nextLine());
//        Location location = new AddressIHM().selectLocation();

    }

}
