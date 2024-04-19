package org.poo_exercices.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercice2 {

    public static int positiveIntScan() throws InputMismatchException, IllegalArgumentException {
        Scanner scan = new Scanner(System.in);
        int result = scan.nextInt();
        if (result < 0) throw new IllegalArgumentException("Entier négatif");
        return result;
    }

    public static void main(String[] args) {
        do {
            System.out.println("Saisissez un entier positif");
            try {
                int entierPositif = positiveIntScan();
                System.out.println("Racine carrée de "+entierPositif+ " = " + Math.sqrt(entierPositif));
                break;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Saisie invalide");
            }
        } while (true);
    }
}
