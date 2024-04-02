package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello world!");

        for (int i = 0; i < 5; i++) {
            System.out.println("i = "+ i);
        }

        // creation d'une variable
        int age = 29; // type name_var = value
        System.out.println(age);
        var firstname = "François";
        System.out.println(firstname.toUpperCase());
        boolean test = true;
        float price = 10.99F; // le F précise le float
        double solde = 100_000.97; // pas besoin de préciser pour le double
        char character = 'c'; // char =>  un seul charactère mis en ' '
        long big_number = 1000000000000000000L; // long pour les très grands nombres (préciser L)

        // lecture à partir de l'écran => JSE => Scanner
        Scanner scanner = new Scanner(System.in);
        String saisie = scanner.nextLine();
        System.out.println(saisie);
        int saisieInt = scanner.nextInt();
        System.out.println(saisieInt);
        float saisieFloat = scanner.nextFloat();
        System.out.println(saisieFloat);

    }
}