package org.jpa_exercice_2.ihm;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.entity.Device;
import org.jpa_exercice_2.repository.ComputerRepository;
import org.jpa_exercice_2.repository.DeviceRepository;

import java.util.List;
import java.util.Scanner;

public class DeviceIHM {
    private static DeviceIHM INSTANCE;
    private final DeviceRepository deviceRepository;
    private DeviceIHM() {
        this.deviceRepository = new DeviceRepository();
    };
    public static synchronized DeviceIHM getInstance() {
        if (INSTANCE == null) INSTANCE = new DeviceIHM();
        return INSTANCE;
    }

    public void start() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                     - - - Périphériques - - -
                    1. Afficher les périphériques
                    2. Ajouter un périphérique
                    3. Associer un modèle d'ordinateur
                    4. Modifier un périphérique
                    5. Supprimer un périphérique
                    [0]. Menu précédent
                    """);
            int choice = sc.nextInt();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> showDevices();
                case 2 -> createDeviceMenu();
                case 3 -> addComputerMenu();
                case 4 -> updateDeviceMenu();
                case 5 -> deleteDeviceMenu();
                default -> System.out.println("Saisie invalide");
            }
        }
    }

    public void showDevices() {
        deviceRepository.getAll().forEach(System.out::println);
    }

    public void createDeviceMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" - - - Ajout d'un périphérique - - -");
        System.out.println("Nom du périphérique :");
        Device device = Device.builder().name(scanner.nextLine()).build();
        deviceRepository.save(device);
        System.out.println();
    }

    public void updateDeviceMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" - - - Modification des périphériques - - -");
        showDevices();
        System.out.println("Sélectionnez le périphériques (id) :");
        Device device = deviceRepository.getById(scanner.nextInt());
        scanner.nextLine();
        if (device != null) {
            System.out.println(device);
            System.out.println("Modifier le nom (actuel: \"" + device.getName() + "\" )");
            String newName = scanner.nextLine();
            if (!newName.equals(device.getName()) || !newName.isBlank()) {
                device.setName(newName);
                deviceRepository.update(device);
                System.out.println("Périphérique modifié");
            } else System.out.println("Aucune modification, retour au menu précédent.");
        } else System.out.println("Ce périphérique n'éxiste pas");
    }

    public void deleteDeviceMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" - - - Suppression d'un périphérique - - - ");
        showDevices();
        System.out.println("Sélectionnez le périphérique (id) :");
        Device device = deviceRepository.getById(scanner.nextInt());
        scanner.nextLine();
        if (device != null) {
            System.out.println(device);
            System.out.println("Voulez vous vraiment supprimer ce périphérique ? [y/n]");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                if (deviceRepository.delete(device))
                    System.out.println("Périphérique supprimé");
            } else {
                System.out.println("Annulation de la suppression");
            }
        } else System.out.println("Ce périphérique n'existe pas");
    }

    public void addComputerMenu() {
        Scanner scanner = new Scanner(System.in);
        ComputerRepository computerRepository = new ComputerRepository();
        List<Computer> computers = computerRepository.getAll();
        if (computers.isEmpty()) {
            System.out.println("Il n'y a aucun ordinateur enregistré\nRetour au menu précédent");
            return;
        }
        System.out.println(" - - - Associer un ordinateur - - -");
        showDevices();
        System.out.println("Sélectionnez le périphérique (id) :");
        Device device = deviceRepository.getById(scanner.nextInt());
        scanner.nextLine();
        if (device != null) {
            while (true) {
                System.out.println(device);
                Computer computer = ComputerIHM.getInstance().selectComputer();
                device.add(computer);
                computer.add(device);
                computerRepository.update(computer);
                deviceRepository.update(device);
                System.out.println("Ajouter un autre ordinateur ? [y/n]");
                if (scanner.nextLine().equalsIgnoreCase("n")) break;
            }
        } else System.out.println("Ce périphérique n'existe pas");
    }
}
