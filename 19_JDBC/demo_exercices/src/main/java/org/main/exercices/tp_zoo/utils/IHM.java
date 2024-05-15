package org.main.exercices.tp_zoo.utils;

import org.main.exercices.tp_zoo.DAO.AnimalDAO;
import org.main.exercices.tp_zoo.DAO.MealDAO;
import org.main.exercices.tp_zoo.entity.Animal;
import org.main.exercices.tp_zoo.entity.Meal;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private static IHM INSTANCE;
    private final AnimalDAO animalDAO;
    private final MealDAO mealDAO;
    private static final Scanner sc = new Scanner(System.in);

    private IHM() {
        try {
            mealDAO = new MealDAO( DataBaseManager.getConnection() );
            animalDAO = new AnimalDAO( DataBaseManager.getConnection(), mealDAO );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static IHM getInstance() {
        if (INSTANCE == null) INSTANCE = new IHM();
        return INSTANCE;
    }

    public void start() {
        while (true) {
            System.out.println("""
                    - - - GESTION DU ZOO - - -
                    1. Afficher les animaux
                    2. Rechercher un animal
                    3. Nourrir un animal
                    4. Ajouter un animal
                    5. Modifier les informations d'un animal [indisponible]
                    6. Supprimer un animal [indisponible]
                    """);
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    default -> { return; }
                    case 1 -> showAnimalList();
                    case 2 -> findAnimal();
                    case 3 -> feedAnimal();
                    case 4 -> addAnimal();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }

    private void findAnimal() throws SQLException {
        System.out.println("- - - Rechercher un animal - - -");
        System.out.println("1. Recherche par nom");
        System.out.println("2. Recherche par habitat");
        System.out.println("3. Rechercher par espèce");
        try {
            int initialChoice = sc.nextInt();
            sc.nextLine();
            AnimalDAO.SearchValue searchValue = switch (initialChoice) {
                case 1 -> AnimalDAO.SearchValue.NAME;
                case 2 -> AnimalDAO.SearchValue.LOCATION;
                case 3 -> AnimalDAO.SearchValue.SPECIE;
                default -> throw new IllegalStateException("Unexpected value: " + initialChoice);
            };
            System.out.println("Recherche : ");
            String value = sc.nextLine();
            System.out.println(value);
            List<Animal> foundsAnimals = animalDAO.find(value, searchValue);
            showAnimalList(foundsAnimals, "Aucun animal trouvé");
            System.out.println("\n appuyez sur entrée pour retourner au menu précécent");
            sc.nextLine();
        } catch (InputMismatchException | IllegalStateException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }
    }

    private void feedAnimal() throws SQLException {
        showAnimalList();
        System.out.println("Sélectionnez un animal (id)");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Description du repas : ");
        String description = sc.nextLine();
        mealDAO.save(Meal.builder()
                .description(description)
                .animal(animalDAO.get(id))
                .build()
        );
    }

    private void showAnimalList(List<Animal> animals, String notFoundMessage) {
        if (animals.isEmpty()) {
            System.out.println(notFoundMessage);
            return;
        }
        animals.forEach(a -> System.out.println("#" + a.getIdAnimal() + " - " + a));
    }

    private void showAnimalList() throws SQLException {
        List<Animal> animals = animalDAO.getAll();
        showAnimalList(animals, "Il n'y a pas d'animaux dans le zoo");
    }

    private void addAnimal() throws SQLException {
        System.out.println("- - - Ajout d'un animal - - -");
        System.out.println("Nom de l'animal : ");
        String name = sc.nextLine();
        System.out.println("Espèce de l'animal : ");
        String specie = sc.nextLine();
        System.out.println("Age de l'animal : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("[Optionnel] Habitat de l'animal : ");
        String location = sc.nextLine();
        System.out.println("[Optionnel] description de l'animal : ");
        String description = sc.nextLine();
        Animal animal = animalDAO.save(Animal.builder()
                .name(name)
                .specie(specie)
                .age(age)
                .location(location)
                .description(description)
                .build()
        );
        System.out.println("Animal ajouté => " + animal);
    }

}
