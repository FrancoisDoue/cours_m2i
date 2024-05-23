package org.exercise_inheritance.ihm;

import org.exercise_inheritance.entity.AbstractProduct;
import org.exercise_inheritance.entity.impl.FoodProduct;
import org.exercise_inheritance.repository.RepositoryStrategy;
import org.exercise_inheritance.repository.impl.ElectronicProductRepository;
import org.exercise_inheritance.repository.impl.FoodProductRepository;
import org.exercise_inheritance.repository.impl.HousingProductRepository;
import org.exercise_inheritance.util.DatabaseManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductIHM {

    private static ProductIHM instance;

    private final ElectronicProductRepository electronicRepository = new ElectronicProductRepository();
    private final FoodProductRepository foodRepository = new FoodProductRepository();
    private final HousingProductRepository housingRepository = new HousingProductRepository();

    private ProductIHM() {}

    public static synchronized ProductIHM getInstance() {
        if (instance == null) instance = new ProductIHM();
        return instance;
    }

    public void start() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                    1. Consulter les produits
                    2. Ajouter un produit
                    3. Modifier un produit [non implémenté]
                    4. Supprimer un produit
                    [0] Quitter
                    """);
            try {
                switch (scanner.nextInt()) {
                    case 1 -> showProductMenu();
                    case 2 -> createProductMenu();
                    case 3 -> {}
                    case 4 -> deleteProductMenu();
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

    public void createProductMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    1. Ajouter un produit alimentaire
                    2. Ajouter un produit électronique [non implémenté]
                    3. Ajouter un produit d'ameublement [non implémenté]
                    [0] Menu précédent
                    """);
            try {
                switch (scanner.nextInt()) {
                    case 1 -> createFood();
                    case 2 -> {}
                    case 3 -> {}
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

    private void createFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("__  produit alimentaire  __");
        System.out.println("Nom :");
        String name = scanner.nextLine();
        double price;
        while (true) {
            try {
                System.out.println("Prix :");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (RuntimeException e){
                System.out.println("saisie invalide");
            }
        }
        LocalDate expirationDate;
        while (true) {
            try {
                System.out.println("Date : (YYYY-MM-DD)");
                expirationDate = LocalDate.parse(scanner.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Date invalide");
            }
        }
        FoodProduct food = FoodProduct.builder().name(name).price(price).expirationDate(expirationDate).build();
        System.out.println(foodRepository.save(food));
        System.out.println("Produit alimentaire ajouté");
    }

    private void deleteProductMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    1. Supprimer un produit alimentaire
                    2. Supprimer un produit électronique
                    3. Supprimer un produit d'ameublement
                    [0] Menu précédent
                    """);
            try {
                switch (scanner.nextInt()) {
                    case 1 -> deleteProductSubMenu(foodRepository);
                    case 2 -> deleteProductSubMenu(electronicRepository);
                    case 3 -> deleteProductSubMenu(housingRepository);
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

    private void deleteProductSubMenu(RepositoryStrategy repository) {
        Scanner scanner = new Scanner(System.in);
        repository.getAll().forEach(System.out::println);
        System.out.println("Sélectionnez l'id du produit : ");
        long id = scanner.nextLong();
        if (repository.delete(repository.getById(id))) {
            System.out.println("Produit supprimé");
        }
    }

    public void showProductMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                    
                    1. Afficher tous les produits
                    2. Afficher les produits alimentaires
                    3. Afficher les produits électroniques
                    4. Afficher les produits d'ameublement
                    [0] Précédent
                    """);
            try {
                switch (scanner.nextInt()) {
                    case 1 -> DatabaseManager.getInstance().getEm()
                            .createQuery("select p from AbstractProduct p", AbstractProduct.class)
                            .getResultList().forEach(System.out::println);
                    case 2 -> foodRepository.getAll().forEach(System.out::println);
                    case 3 -> electronicRepository.getAll().forEach(System.out::println);
                    case 4 -> housingRepository.getAll().forEach(System.out::println);
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
