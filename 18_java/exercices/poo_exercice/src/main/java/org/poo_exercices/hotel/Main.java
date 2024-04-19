package org.poo_exercices.hotel;

import org.poo_exercices.hotel.model.Client;
import org.poo_exercices.hotel.model.Hotel;
import org.poo_exercices.hotel.model.Reservation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Hotel hotel = Hotel.getInstance("");

    public static int saisie(int limit) {
        Scanner sc = new Scanner(System.in);
        do {
            String input = sc.nextLine();
            if (input.matches("[0-" + limit + "]"))
                return Integer.parseInt(input);
            System.out.println("Saisie invalide");
        } while (true);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du hotel: ");
        hotel.setNom(sc.nextLine());
        int choix;
        do {
            System.out.println("""
                    1- Ajouter un client
                    2- Afficher la liste des clients
                    3- Afficher les réservations d’un client
                    4- Ajouter une réservation
                    5- Annuler une réservation
                    6- Afficher la liste des réservations
                    0- Quitter le programme
                    """);
            choix = saisie(6);
            switch (choix) {
                case 1 -> ajouterClient();
                case 2 -> hotel.getClientList().forEach(System.out::println);
                case 3 -> afficherReservation();
                default -> {
                    return;
                }
            }
        } while (true);
    }

    public static void ajouterClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" - Ajouter un client -");
        System.out.println("Nom:");
        String nom = sc.nextLine();
        System.out.println("Prenom:");
        String prenom = sc.nextLine();
        System.out.println("Telephone:");
        String telephone = sc.nextLine();
        Client client = new Client(nom, prenom, telephone);
        hotel.addClient(client);
        System.out.println("Client ajouté : \n " + client + '\n');
    }

    public static void afficherReservation() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    1. Rechercher client par id;
                    2. Rechercher client par Telephone;
                    0. Menu précédent
                    """);
            int choix = saisie(2);
            switch (choix){
                case 1:
                    System.out.println("Saisissez l'id client :");
                        try {
                            List<Reservation> reservations = hotel.getReservationsByClientId(sc.nextInt());
                            if (reservations.isEmpty()) throw new Exception("Ce client n'a pas encore réservé");
                            reservations.forEach(System.out::println);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("saisie invalide");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    break;
                case 2:
                    System.out.println("Saisissez le téléphone client :");
                    try {
                        List<Reservation> reservations = hotel.getReservationsByClientTelephone(sc.nextLine());
                        if (reservations.isEmpty()) throw new Exception("Ce client n'a pas encore réservé");
                        reservations.forEach(System.out::println);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    return;
            }
        } while (true);
    }
}
