package org.design_patterns.exercices.exo_05_1_proxy;

public class Client {
    public static void main(String[] args) {

        SecuredBookProxy book = new SecuredBookProxy("Guerre et Paix", "Beaucoup trop de caractères . . . .");
            book.setUserPremium(true);
        try {
            book.readBook();
            book.setUserPremium(false);
            book.readBook();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
