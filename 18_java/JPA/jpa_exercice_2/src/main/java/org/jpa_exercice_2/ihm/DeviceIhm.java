package org.jpa_exercice_2.ihm;

import org.jpa_exercice_2.model.DeviceModel;

public class DeviceIhm {
    private static DeviceIhm INSTANCE;
    private final DeviceModel deviceModel;
    private DeviceIhm() {
        this.deviceModel = DeviceModel.getInstance();
    };
    public static synchronized DeviceIhm getInstance() {
        if (INSTANCE == null) INSTANCE = new DeviceIhm();
        return INSTANCE;
    }

    public void start() {
        System.out.println("""
                 - - - Périphériques - - -
                1. Afficher les périphériques
                2. Ajouter un périphérique
                3. Modifier un périphérique
                4. Supprimer un périphérique
                """);
    }

    public void showDevices() {
        deviceModel.getAllDevices().forEach(System.out::println);
    }

    public void updateDeviceMenu() {
        System.out.println("Modification des périphériques");
        showDevices();
        System.out.println("Sélectionnez le périphériques (id) :");

    }
}
