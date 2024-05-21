package org.poo_exercices.traders;

import org.poo_exercices.traders.model.Trader;
import org.poo_exercices.traders.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 400),
                new Transaction(brian, 2012, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 410),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // question 1
        System.out.println("\nQuestion 1");
        List<Transaction> sortedTransaction2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        sortedTransaction2011.forEach(System.out::println);

        // Question 2
        System.out.println("\nQuestion 2");
        List<String> listeVille = Arrays.asList(raoul, mario, alan, brian).stream()
                .map(Trader::getCity)
                .distinct()
                .toList();
        listeVille.forEach(System.out::println);

        System.out.println("\nQuestion 2 v2");
        Set<String> listeVille2 = Stream.of(raoul, mario, alan, brian)
                .map(Trader::getCity)
                .collect(Collectors.toSet());
        listeVille2.forEach(System.out::println);

        // Question 3
        System.out.println("\nQuestion 3");
        String listNomTraders = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct().sorted()
                .collect(Collectors.joining(", "));
        System.out.println("listNomTraders = " + listNomTraders);

        // Question 4
        System.out.println("\nQuestion 4");
        Optional<Trader> traderMilanais = Stream.of(raoul, mario, alan, brian)
                .filter(t -> t.getCity().equals("Milan"))
                .findFirst();
        System.out.println("Y a t'il un Trader milanais = " + traderMilanais.isPresent());

        // Question 5
        System.out.println("\nQuestion 5");
        Optional<Integer> plusGrandeTransaction = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue);
        plusGrandeTransaction.ifPresent(System.out::println);


        // Question 6
        System.out.println("\nQuestion 6");
        List<Trader> tradersFromCambridge = Stream.of(raoul, mario, alan, brian)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        tradersFromCambridge.forEach(System.out::println);

        // Question 7
        System.out.println("\nQuestion 7");
        List<Integer> listValeursTransaction = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .toList();
        listValeursTransaction.forEach(System.out::println);

        // Question 8
        System.out.println("\nQuestion 8");
        Transaction minTransaction = transactions.stream()
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList().get(0); // bouuuuh!
        System.out.println("minTransaction = " + minTransaction);

        System.out.println("\nQuestion 8 v2");
        Transaction minTransactionbis = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .get(); // <- c'est ce get sans ifPresent qui me perturbe
        System.out.println("minTransactionbis = " + minTransactionbis);
    }
}
