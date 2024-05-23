package org.jpa_exercice_2.ihm;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.repository.ComputerRepository;

import java.util.Scanner;

public class ComputerIHM {
    private static ComputerIHM INSTANCE;
    private final ComputerRepository computerRepository;
    private ComputerIHM() {
        this.computerRepository = new ComputerRepository();
    }
    public static ComputerIHM getInstance() {
        if (INSTANCE == null) INSTANCE = new ComputerIHM();
        return INSTANCE;
    }

    public void start() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    - - - Ordinateurs - - -
                    1. Afficher les ordinateurs
                    2. Créer un ordinateur
                    [0]. Menu précédent
                    """);
            switch (sc.nextInt()) {
                case 1 -> showComputer();
                case 2 -> createComputer();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Saisie invalide");
            }
        }
    }

    public void showComputer() {
        computerRepository.getAll().forEach(System.out::println);
    }

    public void createComputer() {
        Scanner sc = new Scanner(System.in);
        Computer computer = new Computer();
        System.out.println("- - - Créer un ordinateur - - -");
        System.out.println("Nom de l'ordinateur");
        String name = sc.nextLine();
        // simplifié parce que pas le temps
        if (!name.isEmpty()) {
            computer.setName(name);
            computerRepository.save(computer);
        } else System.out.println("Vous devez renseigner le nom");
    }

    public Computer selectComputer() {
        if (computerRepository.getAll().isEmpty()) {
            System.out.println("Aucun ordinateur");
            return null;
        }
        while (true) {
            Scanner sc = new Scanner(System.in);
            showComputer();
            System.out.println("Sélectionnez un ordinateur (id)");
            Computer computer = computerRepository.getById(sc.nextInt());
            if (computer == null) {
                System.out.println("Cet ordinateur n'existe pas");
                continue;
            }
            return computer;
        }
    }
}
