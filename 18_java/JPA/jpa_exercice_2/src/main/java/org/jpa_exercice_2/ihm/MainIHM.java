package org.jpa_exercice_2.ihm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainIHM {

    public void start() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("""
                        1. Menu Ordinateurs
                        2. Menu périphériques
                        [0]. Quitter
                        """);
                switch (scanner.nextInt()) {
                    case 1 -> ComputerIHM.getInstance().start();
                    case 2 -> DeviceIHM.getInstance().start();

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
