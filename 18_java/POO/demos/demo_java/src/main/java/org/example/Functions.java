package org.example;

public class Functions {
    //<visibilité> <mot-clé poo> <type de retour> <symbole/identificateur> (<type> <paramètres>)
    public static int add(int a, int b) {
        return a + b;
    }
//    public static int add(int a, int b, int c) {
//        return a + b + c;
//    }
//    public static double add(double a, double b, double c) {
//        return a + b + c;
//    }
    public static int sum(int ...inst) {
        int somme = 0;
        for (int i : inst) {
            somme += i;
        }
        return somme;
    }
    public static void addPrint (int a, int b) { // void => aucun type de retour, impossible de récupérer un résultat à l'execution (!= null, 0, "", '\0')
        System.out.println(a + b);
    }
    public static void main(String[] args) {
        var result = add(1, 2);
        addPrint(3, 6);
        System.out.println("result = " + result);
        System.out.println("sum(1,2,3,4) = " + sum(1,2,3,4));
    }
}
