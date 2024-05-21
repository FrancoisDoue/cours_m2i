package org.poo_exercices.pendu;

import java.util.Scanner;

public class IHM {

    public static void start() {
        Pendu jeu = new Pendu();
        System.out.println("display = " + display.length);
        Scanner input = new Scanner(System.in);
        do{
            System.out.println(display[display.length - jeu.getEssais() -1]);
            System.out.println("Le mot à trouver : " + jeu.getMasque());
            System.out.println("Il vous reste " + jeu.getEssais() + " essais");
            String newChar = input.nextLine().toLowerCase();
            if (newChar.matches("^[a-z]$")) {
                jeu.testChar(newChar);
                continue;
            }
            System.out.println("Entrée invalide");
        } while (!(jeu.isWin() || jeu.getEssais() == 0));
        System.out.println(jeu.getMasque());
        if (jeu.isWin()) {
            System.out.println("Bien joué!");
        } else {
            System.out.println(display[display.length - 1]);
            System.out.println("Vous avez perdu");
        }
    }

    public static String[] display = {
            "",
            "==========",
                        """
                ||
                ||
                ||
                ||
                ||
                ||
                ||
                ||
                ||
                ||
            ==========
            """,
            """
                ============
                ||
                ||
                ||
                ||
                ||
                ||
                ||
                ||
                ||
                ||
            ==========""",
            """
                ============
                || //
                ||//
                ||
                ||
                ||
                ||
                ||
                ||
                ||
                ||
            ==========""",
            """
                ============
                || //    |
                ||//     |
                ||/      |
                ||
                ||
                ||
                ||
                ||
                ||
                ||
            ==========""",
            """
                ============
                || //    |
                ||//     |
                ||/      |
                ||       O
                ||       |
                ||       |
                ||
                ||
                ||
                ||
            ==========""",
            """
                ============
                || //    |
                ||//     |
                ||/      |
                ||       O
                ||      /|
                ||       |
                ||
                ||
                ||
                ||
            ==========""",
            """
                ============
                || //    |
                ||//     |
                ||/      |
                ||       O
                ||      /|\\
                ||       |
                ||
                ||
                ||
                ||
            ==========""",
            """
                ============
                || //    |
                ||//     |
                ||/      |
                ||       O
                ||      /|\\
                ||       |
                ||      /
                ||
                ||
                ||
            ==========""",
            """
                ============
                || //    |
                ||//     |
                ||/      |
                ||       O
                ||      /|\\
                ||       |
                ||      / \\
                ||
                ||
                ||
            ==========""",
    };


}
