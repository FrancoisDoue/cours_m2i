package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.exercice.entity.Product;
import org.exercice.service.ProductService;
import org.junit.Assert;

import java.util.List;

public class ProductSteps {

    ProductService productService;
    List<Product> productList = List.of(
            new Product("Serviettes imprimées", "Salle de bain", 20),
            new Product("Gant de toilette", "Salle de bain", 5),
            new Product("Gants de travail", "Bricolage", 25),
            new Product("Marteau", "Bricolage", 20),
            new Product("Tournevis", "Bricolage", 10)
    );
    String search;
    List<Product> searchList;
    List<String> categoryList;
    String selectedCategory;

    @Before
    public void before() {
        productService = new ProductService();
        productService.getProducts().addAll(productList);
    }


    @Given("there is product in list")
    @When("user type a word")
    public void userTypeAWord() {
        search = "gant";
    }

    @Then("user receive a list of products")
    public void userReceiveAListOfProducts() {
        searchList = productService.searchByName(search);
        Assert.assertEquals(2, searchList.size());
    }

    @And("products match with word")
    public void productsMatchWithWord() {
        Assert.assertTrue(productService.searchByName(search).containsAll(
                List.of(productList.get(1), productList.get(2))
        ));
    }


    @Given("there is a list of categories")
    public void thereIsAListOfCategories() {
        categoryList = productService.getCategories();
        Assert.assertEquals(List.of("Salle de bain", "Bricolage"), categoryList);
    }

    @When("user select a category")
    public void userSelectACategory() {
        selectedCategory = categoryList.get(0);
    }

    @Then("User receive a list of products matching category")
    public void userReceiveAListOfProductsMatchingCategory() {
        searchList = productService.getByCategory(selectedCategory);
        boolean isMatching = searchList.stream().allMatch(product -> product.getCategory().equals(selectedCategory));
        Assert.assertTrue(isMatching);
    }
}
