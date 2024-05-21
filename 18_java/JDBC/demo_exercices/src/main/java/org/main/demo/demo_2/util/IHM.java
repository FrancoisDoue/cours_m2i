package org.main.demo.demo_2.util;

import org.main.demo.demo_2.DAO.PlanteDAO;
import org.main.demo.demo_2.entity.Plante;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private Connection connection;
    private PlanteDAO planteDAO;
    private Scanner scanner;
    private List<Plante> plantes;

    public IHM() {
        scanner = new Scanner(System.in);
        try {
            connection = DataBaseManager.getConnection();
            planteDAO = new PlanteDAO(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void start () {
        int entry;
        while (true) {
            System.out.println("""
                    --- GESTION DE PLANTES ---
                    1. Creation de plante
                    2. Afficher les plantes
                    """);
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry) {
                case 1 -> createPlante();
                case 2 -> getAllPlantes();
                default -> {
                    return;
                }
            }
        }
    }

    private void createPlante() {
        System.out.println("Creation de la plante");
        System.out.println("nom de la plante :");
        String name = scanner.nextLine();
        System.out.println("age de la plante :");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("couleur de la plante :");
        String color = scanner.nextLine();
        try {
            Plante plante = planteDAO.createPlante(name, age, color);
            System.out.println("Plante créée");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void getAllPlantes() {
        try {
            plantes = planteDAO.getAllPlantes();
            plantes.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
