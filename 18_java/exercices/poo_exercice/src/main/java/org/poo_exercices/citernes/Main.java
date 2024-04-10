package org.poo_exercices.citernes;


public class Main {
    public static void main(String[] args) {

        Tank citerne1 = new Tank(10, 20, 10);
        Tank citerne2 = new Tank(5, 10, 10);


        System.out.println("Poids total de la citerne 1 : "+citerne1.getTotalMass());
        System.out.println("Poids total de la citerne 2 : "+citerne2.getTotalMass());
        System.out.println("Quantité d'eau dans les citernes : " + Tank.getTotalCurrentVolume());
        System.out.println("----------------------------------------------------------------");

        int leak = citerne1.addWater(11);
        int maxAmount = citerne2.getWater(11);

        System.out.println("Quantité d'eau dans la citerne 1 après ajout de 11 litres : " + citerne1.getCurrentVolume()+"/"+citerne1.getVolumeMax());
        System.out.println("Excès récupéré : " + leak);
        System.out.println("Quantité d'eau dans la citerne 2 après retrait de 11 litres : " + citerne2.getCurrentVolume()+"/"+citerne2.getVolumeMax());
        System.out.println("Quantité d'eau récupérée : "+ maxAmount);
        System.out.println("----------------------------------------------------------------");


        System.out.println("Volume total de la citerne 1 : "+citerne1.getCurrentVolume());
        System.out.println("Volume total de la citerne 2 : "+citerne2.getCurrentVolume());
        System.out.println("Quantité d'eau dans les citernes : " + Tank.getTotalCurrentVolume());

    }

}
