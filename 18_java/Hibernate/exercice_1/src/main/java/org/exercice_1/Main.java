package org.exercice_1;

import org.exercice_1.entity.Product;
import org.exercice_1.repository.ProductRepository;
import org.exercice_1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
                        .brand("marque4")
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

        Session session = HibernateUtil.getFactory().openSession();
        System.out.println("\n2 - Afficher la liste des produits dont le prix est supérieur à 100 euros");
        List<Product> productHigherThan100 = session.createQuery("from Product where price > 100.", Product.class).list();
        productHigherThan100.forEach(System.out::println);

        System.out.println("\n3 - Afficher la liste des produits achetés entre deux dates. (ici entre le 1/03 et 1/06)");
        Query<Product> productBetweenDatesQuery = session.createQuery("from Product where buyingDate between :dateStart and :dateEnd", Product.class);
        productBetweenDatesQuery.setParameter("dateStart", LocalDate.of(2024, 3,1));
        productBetweenDatesQuery.setParameter("dateEnd", LocalDate.of(2024, 6,1));
        productBetweenDatesQuery.getResultList().forEach(System.out::println);


        System.out.println("###############################################################");
        System.out.println("Exercice 3");
        System.out.println("\n1 - Afficher la liste des produits commandés entre deux dates lus au clavier.");

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez deux dates: (format: jj-mm-aaaa) ");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse(sc.nextLine(), df);
        LocalDate date2 = LocalDate.parse(sc.nextLine(), df);
        System.out.println("Résultat entre : " + date1 + " et " + date2);

        Query<Product> productsBetweenInputDate = session.createQuery("from Product where buyingDate between :dateStart and :dateEnd", Product.class);
        productsBetweenInputDate.setParameter("dateStart", date1, LocalDateType.INSTANCE);
        productsBetweenInputDate.setParameter("dateEnd", date2, LocalDateType.INSTANCE);
        productsBetweenInputDate.getResultList().forEach(System.out::println);

        System.out.println("\n2 - retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.");
        System.out.println("Entrez la valeur du stock :");

        Query lowStockProductsQuery = session.createQuery("select id, reference from Product where stock < ?1");
        lowStockProductsQuery.setParameter(1, sc.nextInt(), IntegerType.INSTANCE);
        List lowStockProducts = lowStockProductsQuery.getResultList();

        for (Object product : lowStockProducts) {
            Object[] p = (Object[]) product;
            System.out.println("id : " + p[0] + " | reference " + p[1]);
        }
        sc.nextLine();

        session.close();
        HibernateUtil.close();

    }
}