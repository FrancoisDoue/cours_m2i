package org.exercice_1;

import org.exercice_1.entity.Comment;
import org.exercice_1.entity.Image;
import org.exercice_1.entity.Product;
import org.exercice_1.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

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


        productRepository.addImage(1, Image.builder().url("/une/url.jpg ").build());
        productRepository.addImage(1, Image.builder().url("/une/autre/url.jpg ").build());
        productRepository.addImage(2, Image.builder().url("/une/super/url.jpg ").build());
        productRepository.addImage(2, Image.builder().url("/une/super/url.jpg ").build());


//        Product product1 = productRepository.get(1);
        productRepository.addComment(1, Comment.builder().note(5).content("Super produit").build());
        productRepository.addComment(1, Comment.builder().note(2).content("bof").build());
        productRepository.addComment(2, Comment.builder().note(5).content("Super produit").build());
        productRepository.addComment(2, Comment.builder().note(4).content("Presque parfait").build());
        productRepository.addComment(3, Comment.builder().note(4).content("Presque parfait").build());
        productRepository.addComment(3, Comment.builder().note(5).content("Super produit").build());
        productRepository.addComment(3, Comment.builder().note(5).content("Super produit").build());
        productRepository.addComment(3, Comment.builder().note(4).content("Presque parfait").build());
        productRepository.addComment(3, Comment.builder().note(3).content("Ok!").build());


        System.out.println(productRepository.get(1));

        productRepository.getAllWithAvgNotation(4).forEach(System.out::println);

//        productRepository.addComment(3, Comment.builder().content("Excellent produit").note(5).build());

    }
}
