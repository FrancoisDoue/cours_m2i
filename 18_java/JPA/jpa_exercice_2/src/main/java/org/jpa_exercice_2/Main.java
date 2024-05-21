package org.jpa_exercice_2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


    public static void main(String[] args) {
        IHM ihm = new IHM();
        ihm.start();
    }


}