package org.jpa_exercice_2;

import org.jpa_exercice_2.ihm.DeviceIHM;

public class Main {


    public static void main(String[] args) {
//        IHM ihm = new IHM();
//        ihm.start();
        DeviceIHM ihm = DeviceIHM.getInstance();
        ihm.start();
    }


}