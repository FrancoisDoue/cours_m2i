package org.exercice_1;

import org.exercice_1.entity.Product;
import org.exercice_1.repository.ProductRepository;
import org.exercice_1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LocalDateType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();
        List<Product> products = List.of(
                Product.builder()
                        .brand("marque1").reference("model1")
                        .buyingDate(LocalDate.of(2024,3,8))
                        .price(5).stock(5).build(),
                Product.builder()
                        .brand("marque2").reference("model2")
                        .buyingDate(LocalDate.of(2024,5,26))
                        .price(10).stock(8).build(),
                Product.builder()
                        .brand("marque3")
                        .buyingDate(LocalDate.of(2024,2,15))
                        .price(120).stock(5).build(),
                Product.builder()
                        .brand("marque3")
                        .buyingDate(LocalDate.of(2024,2,28))
                        .price(110).stock(50).build(),
                Product.builder()
                        .brand("marque5")
                        .buyingDate(LocalDate.of(2024,5,29))
                        .price(50).stock(2).build()
        );
        System.out.println("Exercice 1");

        productRepository.saveMultiple(products);

//        System.out.println(productRepository.get(2));
//        if (productRepository.delete(productRepository.get(3))) {
//            System.out.println("Produit avec id  = 3  supprimé");
//        }
//        Product updatedProduct = productRepository.get(1);
//        updatedProduct.setBrand("Un excellent produit");
//        System.out.println(productRepository.update(updatedProduct));

        System.out.println("###############################################################");
        System.out.println("Exercice 2");
        System.out.println("\n1 - Afficher la totalité des produits");
        productRepository.getAll().forEach(System.out::println);

        System.out.println("\n2 - Afficher la liste des produits dont le prix est supérieur à 100 euros");

        productRepository.getByPriceHigherThan(100).forEach(System.out::println);

        System.out.println("\n3 - Afficher la liste des produits achetés entre deux dates. (ici entre le 1/03 et 1/06)");
        productRepository.getByDateBetween(
                LocalDate.of(2024, 3,1),
                LocalDate.of(2024, 6,1)
        ).forEach(System.out::println);


        System.out.println("###############################################################");
        System.out.println("Exercice 3");
        System.out.println("\n1 - Afficher la liste des produits commandés entre deux dates lus au clavier.");

        Scanner sc = new Scanner(System.in);

        System.out.println("\n2 - retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.");
        System.out.println("Entrez la valeur du stock :");
        List lowStockProducts = productRepository.getByStockLowerThan(sc.nextInt());
        sc.nextLine();
        for (Object product : lowStockProducts) {
            Object[] p = (Object[]) product;
            System.out.println("id : " + p[0] + " | reference " + p[1]);
        }

        Session session = HibernateUtil.getFactory().openSession();
        System.out.println("###############################################################");
        System.out.println("Exercice 4");
        System.out.println("\n1 - Afficher la valeur du stock des produits d'une marque choisie.");

        List<Double> totalValueByBrand = session.createQuery("select (stock*price) from Product where brand = 'marque3'", Double.class).getResultList();
        totalValueByBrand.forEach(t -> System.out.println(" -> " + t));

        System.out.println("\n2 - Calculer le prix moyen des produits.");
        Double avgPrice = session.createQuery("select avg(price) from Product ", Double.class).getSingleResult();
        System.out.println("Prix moyen des produits du  catalogue : " + avgPrice);

        System.out.println("\n3 - Récupérer la liste des produits d'une marque choisie.");
        List<Product> productsByBrand = session.createQuery("from Product where brand = 'marque3'", Product.class).getResultList();
        productsByBrand.forEach(System.out::println);
        session.close();

        // pas possible pour le moment?
        System.out.println("\n4 - Supprimer les produits d'une marque choisie de la table produit.");
        System.out.println("Nombre de ligne affectée par la suppression de 'marque3' : " + productRepository.deleteByBrand("marque3"));

        HibernateUtil.close();

    }
}