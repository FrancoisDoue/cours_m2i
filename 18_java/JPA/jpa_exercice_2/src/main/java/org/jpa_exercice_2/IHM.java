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
                    2. Modifier un ordinateur existant
                    3. Supprimer un ordinateur
                    4. Assigner une adresse IP
                    5. Afficher tous les ordinateurs
                    6. Afficher les IP enregistrées
                    [0] Quitter
                    """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> createComputerMenu();
                case 2 -> updateComputerMenu();
                case 3 -> deleteComputerMenu();
                case 4 -> setIpMenu();
                case 5 -> showComputers();
                case 6 -> showIdentifications();
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

    private void updateComputerMenu() {
        Scanner sc = new Scanner(System.in);
        showComputers();
        System.out.println("Choisir un ordinateur (id)");
        Computer computer = getComputer(sc.nextInt());
        sc.nextLine();
        System.out.println("Saisir le modèle : ");
        computer.setName(sc.nextLine());
        System.out.println("Saisir une description (optionnel) :");
        String description = sc.nextLine();
        if (!description.equals("")) {
            computer.setDescription(description);
        }
        System.out.println(updateComputer(computer));
    }

    private void deleteComputerMenu() {
        Scanner sc = new Scanner(System.in);
        showComputers();
        System.out.println("Choisir un ordinateur (id)");
        int id = sc.nextInt();
        Computer computer = getComputer(id);
        if (em.contains(computer)) {
            removeComputer(computer);
            if (getComputer(id) == null)
                System.out.println("Ordinateur supprimé avec succès");
        }
    }

    private Computer createComputer(String name) {
        Computer computer = Computer.builder().name(name).build();
        return updateComputer(computer);
    }

    private Computer updateComputer(Computer computer) {
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
        Identification identification = Identification.builder().ip(ip).build();
        computer.setIdentification(identification);
        em.getTransaction().begin();
        em.persist(computer);
        em.getTransaction().commit();
    }

}
