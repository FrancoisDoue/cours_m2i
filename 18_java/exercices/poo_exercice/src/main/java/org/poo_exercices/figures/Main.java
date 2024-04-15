package org.poo_exercices.figures;

import org.poo_exercices.figures.model.Carre;
import org.poo_exercices.figures.model.Rectangle;
import org.poo_exercices.figures.model.Triangle;

public class Main {
    public static void main(String[] args) {
        Carre carre = new Carre(0,0, 2);
        System.out.println("carre = " + carre);
        
        Rectangle rectangle = new Rectangle(-1, -1, 6, 4);
        System.out.println("rectangle = " + rectangle);
        rectangle.deplacer(5, 9);
        System.out.println("rectangle = " + rectangle);


        Triangle triangle = new Triangle(-0, -0, 6, 4);
        System.out.println("triangle = " + triangle);
        triangle.deplacer(20, 15);
        System.out.println("triangle = " + triangle);
    }
}
