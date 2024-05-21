package org.poo_exercices.personne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private static Scanner sc = new Scanner(System.in);
    private static String entreprise = "La meilleur boîte du monde";
    private static String adresse = "4 av. de l'Horizon 59650 VILLENEUVE-D'ASCQ";
    private static List<Personne> employes = new ArrayList<Personne>();

    public static int saisie(int limit) {
        // cf exercice compte bancaire
        return org.poo_exercices.compte_bancaire.IHM.saisie(limit);
    }
    public static void menu() {
        int choix = 0;
        do {
            System.out.printf("""
                    === %s ===
                    === Gestion du personnel ===
                    1. Ajouter un Travailleur
                    2. ajouter un Scientifique
                    3. Afficher la liste du personnel
                    0. Quitter ce programme
                    """, entreprise);
            switch (choix = saisie(3)) {
                case 1:
                    ajouterTravailleur(false);
                    break;
                case 2:
                    ajouterTravailleur(true);
                    break;
                case 3:
                    if(employes.isEmpty())
                        System.out.println("Vous avez déjà viré tout le monde !");
                    else
                        employes.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Merci d'avoir utilisé ce programme.");
                    break;
            }

        } while (choix != 0);
    }

    private static void ajouterTravailleur(boolean isScientist) {
        int choix;
        do {
            String[] infos = new String[8];
            infos[3] = entreprise;
            infos[4] = adresse;

            System.out.println("=== Ajouter un travailleur ===");

            System.out.println("Nom : ");
            infos[0] = sc.nextLine();
            System.out.println("Prénom : ");
            infos[1] = sc.nextLine();
            System.out.println("Telephone : ");
            infos[2] = sc.nextLine();
            System.out.println("Telephone pro : ");
            infos[5] = sc.nextLine();
            if (isScientist) {
                System.out.println("Domaine d'expertise");
                infos[6] = sc.nextLine();
                System.out.println("Type d'expertise : ");
                infos[7] = sc.nextLine();
            }
            employes.add((isScientist) ? new Scientifique(infos) : new Travailleur(infos));
            System.out.printf(
                    "Ajouter un autre %s\n1. Oui \n0. Non \n",
                    (isScientist)? "Scientifique": "Travailleur"
            );
            choix = saisie(1);
        } while (choix != 0);
    }
}
