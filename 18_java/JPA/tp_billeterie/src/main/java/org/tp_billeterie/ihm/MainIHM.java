package org.tp_billeterie.ihm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainIHM {


    public void start() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    1. Gestion des clients
                    2. Organiser un évènement
                    [0] Quitter
                    """);
            try {
                switch (sc.nextInt()) {
                    case 1 -> new ClientIHM().start();
                    case 2 -> {}
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
}
