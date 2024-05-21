package org.poo_exercices.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        do {
            System.out.println("Saisissez un nombre entier");
            Scanner sc = new Scanner(System.in);
            int n;
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException | NumberFormatException e) { // " | " proposé par IntelliJ
                System.out.println("Saisie invalide");
                continue;
            }
            System.out.println("nombre = " + n);
            break;
        } while (true);
    }
}
