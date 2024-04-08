package org.exercice_functions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercices {
    public static String fullName(String fname, String lname) {
        return fname + " " + lname;
    }

    public static int soustraction(int a, int b) {
        System.out.println("Je soustrais " + a + " et " + b);
        return a - b;
    }

    public static void quelleHeure(String heure) {
        System.out.println("Il est " + heure);
    }
    public static void quelleHeure() {
        quelleHeure("12h00");
    }

    public static int compterLettre(String phrase, char letter) {
        int compteur = 0;
        for (char a : phrase.toLowerCase().toCharArray()) {
            if (a == letter) {
                compteur++;
            }
        }
        return compteur;
    }

    public static int compterLettreA(String phrase) {
        return compterLettre(phrase, 'a');
    }

    public static boolean verificationAdn(String dna) {
        for (char letter : dna.toLowerCase().toCharArray()) {
            if (!(letter == 'a' || letter == 'c' || letter == 'g' || letter == 't'))
                return false;
        }
        return true;
    }

    public static String saisieAdn() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Saisissez la séquence ADN");
            String tryDna = input.nextLine();
            if (verificationAdn(tryDna)) return tryDna;
            System.out.println("Il ne s'agit pas d'une séquence ADN valide");
        } while (true);
    }

    public static double proportion(String adn, String sequence) {
        String regAdn = "(?:" + sequence.toLowerCase() + ")";
        Pattern patternSequence = Pattern.compile(regAdn.toLowerCase());
        Matcher matchAdn = patternSequence.matcher(adn);
        int cnt = 0;
        while (matchAdn.find()) {
            cnt++;
        }
        return (double) (sequence.length() * cnt) / adn.length() * 100;
//        return 100. * (sequence.length() * cnt) / adn.length();

    }

    public static void main(String[] args) {
        var name = fullName("John", "Doe");
        System.out.println(name);
        var substraction = soustraction(2, 1);
        System.out.println("substraction = " + substraction);
        quelleHeure();
        quelleHeure("11h46");
        var howManyA = compterLettreA("C'est le B-A BA");
        System.out.println("combien de a dans \"C'est le B-A BA\" = " + howManyA);
        System.out.println("isDNA(\"agtAqTgta\") = " + verificationAdn("agtATgta"));
        String newDna = saisieAdn();
        System.out.println("Maintenant, saisissez la séquence");
        String sequenceDna = saisieAdn();
        double result = proportion(newDna, sequenceDna);
        System.out.println(result + "% du total");
    }

}
