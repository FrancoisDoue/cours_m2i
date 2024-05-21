package org.poo_exercices.exceptions;

public class Exercice3 {
    public static void main(String[] args) {
        int[] tableau = { 1, 2, 3, 4, 5 };
        try{
            System.out.println(tableau[8]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException" + e.getMessage());
        }
    }
}
