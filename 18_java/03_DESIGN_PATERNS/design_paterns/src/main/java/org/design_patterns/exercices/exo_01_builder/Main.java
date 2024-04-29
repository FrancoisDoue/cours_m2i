package org.design_patterns.exercices.exo_01_builder;

public class Main {
    public static void main(String[] args) {
        try {
            Pizza pizzananas = new Pizza.PizzaBuilder()
                    .ajouterFromage("Mozzarella")
                    .ajouterGarniture("Ananas")
                    .build();
            System.out.println("pizzananas = " + pizzananas);

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        try {
            Pizza regina = new Pizza.PizzaBuilder()
                    .taille(Pizza.Taille.GRANDE)
                    .ajouterFromage("Mozza", "Mozza")
                    .build();
            System.out.println("regina = " + regina);

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        try {
            Pizza pizzaRaclette = new Pizza.PizzaBuilder()
                    .taille(Pizza.Taille.MOYENNE)
                    .typePate(Pizza.TypePate.EPAISSE)
                    .ajouterFromage("Raclette", "Mozzarella")
                    .ajouterGarniture("Lardons", "Pomme de terre")
                    .build();
            System.out.println("pizzaRaclette = " + pizzaRaclette);

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }
}
