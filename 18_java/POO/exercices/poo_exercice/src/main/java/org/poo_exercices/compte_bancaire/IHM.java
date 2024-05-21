package org.poo_exercices.compte_bancaire;

import org.poo_exercices.compte_bancaire.comptes.CompteBancaire;
import org.poo_exercices.compte_bancaire.comptes.CompteCourant;
import org.poo_exercices.compte_bancaire.comptes.CompteEpargne;
import org.poo_exercices.compte_bancaire.comptes.ComptePayant;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private static final Client client = new Client("Abitbol", "Georges", "0666066600");

    public static int saisie(int limit) {
        Scanner sc = new Scanner(System.in);
        do {
            String input = sc.nextLine();
            if (input.matches("[0-" + limit + "]"))
                return Integer.parseInt(input);
            System.out.println("Saisie invalide");
        } while (true);
    }

    public static double saisieMontant() {
        Scanner sc = new Scanner(System.in);
        do {
            String input = sc.nextLine();
            // pas ma regex, mais je l'ai modifié
            if (input.matches("^(0|([1-9][0-9]*))(\\.[0-9]{0,2}+)?$"))
                return Double.parseDouble(input);
            System.out.println("Saisie invalide");
        } while (true);
    }

    public static void menuPrincipal() {
        int choix;
        do {
            System.out.printf("""
                    ==== Menu Principal ====
                    Bonjour %s %s
                    ========================
                    1. Gérer vos comptes bancaires
                    2. Créer un compte bancaire
                    0. Quitter ce programme
                    """, client.getPrenom(), client.getNom());
            System.out.printf("Votre choix : %s \n", choix = saisie(2));

            switch (choix) {
                case 1:
                    listerComptes();
                    break;
                case 2:
                    creerCompteBancaire();
                    break;
                default:
                    System.out.println("\nMerci d'avoir utilisé ce programme\n");
            }
        } while (choix != 0);
    }

    public static void listerComptes() {
        int choix = 0;
        List<CompteBancaire> comptes = client.getComptesBancaires();
        do {
            System.out.println("\nListe des comptes bancaires\n");
            if (comptes.isEmpty()) {
                System.out.println("Vous n'avez actuellement aucun compte actuellement\n0. Revenir au menu principal");
            } else {
                int[] cpt = {1}; // doit être une entrée de tableau pour le foreach (???)
                comptes.forEach(
                        compte -> System.out.printf("%s. %s\n", cpt[0]++, compte)
                );
                System.out.println("0. Revenir au menu principal");
                choix = saisie(cpt[0] - 1);
                System.out.println("choix = " + choix);
                if (choix != 0) {
                    gererCompteBancaire(comptes.get(choix - 1));
                }
            }
        } while (choix != 0);
    }

    public static void creerCompteBancaire() {
        int choix;
        String[] nomCompte = {"Compte courant", "Compte épargne", "Compte payant"};
        String finSucces = " créé avec succès";
        do {
            System.out.println("""
                    ==== Créer un compte ====
                    1. Créer un compte courant
                    2. Créer un compte épargne
                    3. Créer un compte payant
                    0. Revenir au menu précédent
                    """);
            switch (choix = saisie(3)) {
                case 1:
                    new CompteCourant(client);
                    break;
                case 2:
                    new CompteEpargne(client);
                    break;
                case 3:
                    new ComptePayant(client);
                    break;
                default:
                    System.out.println("\nRetour au menu principal\n");
                    break;
            }
            if (choix != 0)
                System.out.println(nomCompte[choix - 1] + finSucces);
        } while (choix != 0);
    }

    public static void gererCompteBancaire(CompteBancaire compte) {
        int choix;
        double montant;
        DecimalFormat df = new DecimalFormat("#.##");
        do {
            System.out.printf("""
                    === Compte %s | solde: %s € ===
                    1. Faire un dépôt
                    2. Faire un retrait
                    3. Consulter les opérations
                    0. Retour au menu précédent
                    """, compte.getId(), df.format(compte.getSolde()));

            switch (choix = saisie(3)) {
                case 1:
                    System.out.println("Saisissez le montant de votre dépôt");
                    montant = saisieMontant();
                    Operation operationDepot = new Operation(Operation.Type.DEPOT, montant);
                    compte.addOperation(operationDepot);
                    System.out.println("Dépot réussi, nouveau solde : " + df.format(compte.getSolde()) + " €");
                    break;

                case 2:
                    System.out.println("Saisissez le montant de votre retrait");
                    montant = saisieMontant();
                    Operation operationRetrait = new Operation(Operation.Type.RETRAIT, montant);
                    if (compte.addOperation(operationRetrait)) {
                        System.out.println("Retrait effectué, nouveau solde : " + df.format(compte.getSolde()) + "€");
                    } else {
                        System.out.println("\u001B[31mRetrait impossible: fonds insuffisants\u001B[0m");
                    }
                    break;

                case 3:
                    List<Operation> listeOperation = compte.getOperations();
                    listeOperation.forEach(System.out::println);
                    break;

                default:
                    System.out.println("\nRetour au menu précédent\n");
                    break;
            }
        } while (choix != 0);
    }

}
