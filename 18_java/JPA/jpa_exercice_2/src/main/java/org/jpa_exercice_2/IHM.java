package org.jpa_exercice_2;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.entity.Identification;
import org.jpa_exercice_2.entity.OS;
import org.jpa_exercice_2.entity.Processor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

// Ne sera plus utilisé
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
                    7. Ajouter un Processeur
                    8. Afficher les processeurs
                    9. Ajouter un OS
                    10. Afficher les OS
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
                case 7 -> createProcessorMenu();
                case 8 -> getProcessors().forEach(p -> System.out.println(p.toFullString()));
                case 9 -> createOSmenu();
                case 10 -> getOSs().forEach(System.out::println);
                default -> System.out.println("Saisie invalide");
            }
        }
    }

    private void createComputerMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Modèle de l'ordinateur : ");
        String computerName = sc.nextLine();
        getOSs().forEach(System.out::println);
        System.out.println("Choisissez un processeur");
        OS os = getOS(sc.nextInt());
        sc.nextLine();
        System.out.println(os);
        getProcessors().forEach(System.out::println);
        System.out.println("Choisissez un os");
        Processor processor = getProcessor(sc.nextInt());
        sc.nextLine();
        System.out.println(processor);
        System.out.println(createComputer(
                Computer.builder()
                        .name(computerName)
                        .os(os)
                        .processor(processor)
                        .build()
        ));
    }

    private void showComputers() {
        getComputers().forEach(System.out::println);
    }

    private void showIdentifications() {
        getIdentifications().forEach(e -> System.out.println(e.toFullString()));
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
        if (!description.isEmpty()) {
            computer.setDescription(description);
        }
        System.out.println(createComputer(computer));
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

    private List<OS> getOSs() {
        return em.createQuery("select os from OS os", OS.class).getResultList();
    }

    private OS getOS(int id) {
        return em.find(OS.class, id);
    }

    private List<Processor> getProcessors() {
        return em.createQuery("select p from Processor p", Processor.class).getResultList();
    }

    private Processor getProcessor(int id) {
        return em.find(Processor.class, id);
    }

    private void createOSmenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Référence du système d'exploitation :");
        OS os = OS.builder().name(sc.nextLine()).build();
        em.getTransaction().begin();
        em.persist(os);
        em.getTransaction().commit();
        System.out.println(os);
    }

    private void createProcessorMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Référence du processeur : ");
        String processorName = sc.nextLine();
        System.out.println("Nombre de coeurs : ");
        int cores = sc.nextInt();
        sc.nextLine();
        System.out.println("Vitesse (en GHz) : ");
        double speed = Double.parseDouble(sc.nextLine());
        Processor processor = Processor.builder().name(processorName).core(cores).speed(speed).build();
        em.getTransaction().begin();
        em.persist(processor);
        em.getTransaction().commit();
        System.out.println(processor);
    }



    private Computer createComputer(Computer computer) {
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
        return em.createQuery("select c.identification from Computer c", Identification.class).getResultList();
    }

    private void removeComputer(Computer computer) {
        em.getTransaction().begin();
        em.remove(computer);
        em.getTransaction().commit();
    }

    private void setIpToComputer(Computer computer, String ip) {
        Identification identification = Identification.builder().ip(ip).computer(computer).build();
        computer.setIdentification(identification);
        em.getTransaction().begin();
        em.merge(computer);
        em.getTransaction().commit();
    }

}
