package org.main.exercices.util;

import org.main.exercices.DAO.FilmDAO;
import org.main.exercices.Entity.Film;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Predicate;

public class IHM {

    private Connection connection;
    private FilmDAO filmDAO;
    private final Scanner scanner = new Scanner(System.in);

    public IHM() {
        try {
            connection = DataBaseManager.getConnection();
            filmDAO = new FilmDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void start () {
        while (true) {
            System.out.println("""
                    Filmothèque
                    1. Afficher les films
                    2. Ajouter un film
                    3. Modifier un film
                    4. Supprimer un film
                    """);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> showFilms();
                case 2 -> addFilm();
                case 3 -> updateFilm();
                case 4 -> deleteFilm();
                default -> { return; }
            }
        }
    }

    public void updateFilm () {
        showFilms();
        System.out.println("Sélectionnez l'id du film à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        Film film = filmDAO.getFilms().stream()
                .filter(f -> f.getIdFilm() == id)
                .findFirst().orElse(null);
        if (film == null) {
            System.out.println("Ce film n'existe pas");
            return;
        } else System.out.println(film);
        System.out.println("Titre (actuel : \"" + film.getTitle() + "\"");
        String title = scanner.nextLine();
        if (!title.isEmpty())
            film.setTitle(title);
        System.out.println("Réalisateur : \"" + film.getDirector() + "\"");
        String director = scanner.nextLine();
        if (!director.isEmpty())
            film.setDirector(title);
        try {
            if (filmDAO.updateFilm(film)) {
                System.out.println("Film modifié");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteFilm () {
        showFilms();
        System.out.println("Sélectionnez l'id du film à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            if (filmDAO.deleteFilm(id)) {
                System.out.println("Film supprimé avec succès");
            } else {
                System.out.println("ce film n'existe pas");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFilms () {
        try {
            filmDAO.readFilms().forEach(f -> System.out.println("#" + f.getIdFilm() + " " + f));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addFilm () {
        System.out.println("Ajouter un film :");
        System.out.println("Titre:");
        String title = scanner.nextLine();
        System.out.println("Réalisateur");
        String director = scanner.nextLine();
        System.out.println("Année de sortie");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mois de sortie");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Jour de sortie");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Genre");
        String genre = scanner.nextLine();

        try {
            Film film = filmDAO.createFilm(title, director, LocalDate.of(year, month, day), genre);
            System.out.println("Film créé => " + film);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
