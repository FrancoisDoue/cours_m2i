package org.design_patterns.exercices.tp_03.entity;

import java.util.Scanner;

public class IHM {
    public static int input(int limit) {
        Scanner sc = new Scanner(System.in);
        do {
            String input = sc.nextLine();
            if (input.matches("[0-" + limit + "]"))
                return Integer.parseInt(input);
            System.out.println("Saisie invalide");
        } while (true);
    }

    public static void mainMenu() {
        int userInput;
        do {
            System.out.println("""
                    1. Créer un investisseur
                    2. Voir la liste des investisseur
                    0. Quitter
                    """);
            switch (userInput = input(1)) {
                case 1 -> {

                    System.out.println("Nom de l'investisseur");

                }
                case 2 -> {}
                default -> System.out.println("Au revoir");
            }

        } while (userInput != 0);
    }
}
