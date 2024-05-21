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
                    3. Afficher un ordinateur
                    4. Afficher tous les ordinateurs
                    [0] Quitter
                    """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("Modèle de l'ordinateur : ");
                    System.out.println(createComputer(sc.nextLine()));
                }
                case 2 -> {

                }
                case 3 -> {}
                case 4 -> {}
                default -> System.out.println("Saisie invalide");
            }
        }
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

    private void removeComputer(Computer computer) {
        em.getTransaction().begin();
        em.remove(computer);
        em.getTransaction().commit();
    }

    private void setIpToComputer(Computer computer, String ip) {
        computer.setIdentification(
                Identification.builder().ip(ip).build()
        );
        em.getTransaction().begin();
        em.persist(computer);
        em.getTransaction().commit();
    }

}
