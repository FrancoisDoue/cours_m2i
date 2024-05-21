package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//        temperatureConverter();
//        candies();
        timerMessage();
    }
    // exercice 1
    public static void temperatureConverter(){
        System.out.println("Renseignez la température à convertir en celsius :");
        float farhenheit = input.nextFloat();
        System.out.println("conversion : " + farhenheit + "°F = " + ((farhenheit - 32) * 5/9) + "°C");
        System.out.println("Renseignez la température à convertir en farenheit :");
        float celsius = input.nextFloat();
        System.out.println("conversion : " + celsius + "°C = " + ((celsius * 5/9) + 32) + "°F");
    }
    // exercice 2
    public static void candies() {
        float candyPrice = .65F;
        System.out.println("Combien de bonbons souhaitez vous acheter? (Prix du bonbon: "+ candyPrice +"€)");
        int candyQty = input.nextInt();
        System.out.println("Prix total pour " + candyQty + " bonbons: " + (candyPrice*candyQty)+ " €");
    }
    // exercice 3
    public static void timerMessage() {
        System.out.println("Tappez votre message : ");
        String firstMessage = input.nextLine();
        long time = System.currentTimeMillis();
        System.out.println(firstMessage);
        System.out.println("Tappez votre second message : ");
        String secondMessage = input.nextLine();
        double elapsedTime = (System.currentTimeMillis() - time) / 1000.0;
        System.out.println(secondMessage);
        System.out.println("Temps écoulé depuis votre dernier message: " + elapsedTime + " sec");
    }
}