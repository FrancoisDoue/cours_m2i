package org.poo_demo.demo_interface;

public class Main {
    public static void main(String[] args) {
        Cercle cercle = new Cercle("Cercle 1", 5.0);

        Rectangle rectangle = new Rectangle("Rectangle 1", 5.0, 6.0);

        Forme[] formes = new Forme[]{cercle, rectangle};

        for (Forme forme : formes) {
            System.out.println("forme = " + forme);
        }

        Calculable[] formes2 = new Calculable[]{cercle, rectangle};
    }
}
