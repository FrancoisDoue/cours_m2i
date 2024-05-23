package org.jpa_exercice_2.ihm;

public class ComputerIHM {
    private static ComputerIHM INSTANCE;
    private final ComputerRepository computerRepository;
    private ComputerIHM() {
        this.computerRepository = new ComputerRepository();
    }
    public static ComputerIHM getInstance() {
        if (INSTANCE == null) INSTANCE = new ComputerIHM();
        return INSTANCE;
    }
}
