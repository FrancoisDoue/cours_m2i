package org.poo_exercices.exceptions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Exercice4 {
    public static List<Student> studentList = new ArrayList<Student>();

    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Saisie invalide");
            }
        } while (true) ;

    }

    public static void main(String[] args) {
        do {
            System.out.println("""
                    1. Ajouter un étudiant
                    2. Afficher la liste des étudiants
                    0. Quitter le programme
                    """);
            Scanner scanner = new Scanner(System.in);
            int choice = scanInt();
            switch (choice) {
                case 1 :
                    do {
                        try {
                            System.out.println("Nom :");
                            String nom = scanner.nextLine();
                            System.out.println("Age :");
                            int age = scanInt();
                            studentList.add(
                                    new Student(age, nom)
                            );
                            break;
                        } catch (InputMismatchException | InvalidAgeException e) {
                            System.out.println("Saisie invalide");
                        }
                    } while (true);
                    break;
                case 2 :
                    studentList.forEach(System.out::println);
                    break;
                default:
                    return;
            }
        }while (true);
    }
}
