package org.jpa_exercice_2;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.entity.Identification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_exercice_2");
    private EntityManager em = emf.createEntityManager();

    public void start() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    1. Créer un ordinateur
                    2. Assigner une adresse IP
                    3. Afficher tous les ordinateurs
                    4. Afficher les IP enregistrées
                    [0] Quitter
                    """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> createComputerMenu();
                case 2 -> setIpMenu();
                case 3 -> showComputers();
                case 4 -> showIdentifications();
                default -> System.out.println("Saisie invalide");
            }
        }
    }

    private void createComputerMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Modèle de l'ordinateur : ");
        System.out.println(createComputer(sc.nextLine()));
    }

    private void showComputers() {
        getComputers().forEach(System.out::println);
    }

    private void showIdentifications() {
        getIdentifications().forEach(System.out::println);
    }

    private void setIpMenu() {
        Scanner sc = new Scanner(System.in);
        showComputers();
        System.out.println("Sélectionnez un ordinateur (id)");
        Computer computer = getComputer(sc.nextInt());
        sc.nextLine();
        System.out.println("Saisir l'ip : ");
        setIpToComputer(computer, sc.nextLine());
        System.out.println(getComputer(computer.getId()));
    }

    private Computer createComputer(String name) {
        Computer computer = Computer.builder().name(name).build();
        em.getTransaction().begin();
        em.persist(computer);
        em.getTransaction().commit();
        return computer;
    }

    private Computer getComputer(int id) {
        return em.find(Computer.class, id);
    }

    private List<Computer> getComputers() {
        return em.createQuery("select c from Computer c", Computer.class).getResultList();
    }

    private List<Identification> getIdentifications() {
        return em.createQuery("select i from Identification i", Identification.class).getResultList();
    }

    private void removeComputer(Computer computer) {
        em.getTransaction().begin();
        em.remove(computer);
        em.getTransaction().commit();
    }

    private void setIpToComputer(Computer computer, String ip) {
        Identification identification = Identification.builder().ip(ip).computer(computer).build();
        em.getTransaction().begin();
        em.persist(identification);
        em.getTransaction().commit();
    }

}
