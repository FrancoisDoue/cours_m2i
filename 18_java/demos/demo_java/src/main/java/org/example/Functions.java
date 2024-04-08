package org.example;

public class Functions {
    //<visibilité> <mot-clé poo> <type de retour> <symbole/identificateur> (<type> <paramètres>)
    public static int add(int a, int b) {
        return a + b;
    }
    public static void addPrint (int a, int b) { // void => aucun type de retour, impossible de récupérer un résultat à l'execution (!= null, 0, "", '\0')
        System.out.println(a + b);
    }
    public static void main(String[] args) {
        var result = add(1, 2);
        addPrint(3, 6);
        System.out.println("result = " + result);
    }
}
