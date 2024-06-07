package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bdd_exo_1.entity.Product;
import org.bdd_exo_1.repository.impl.ProductRepository;
import org.bdd_exo_1.service.ProductService;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ProductSteps {

    private String search;
    private List<Product> resultList;
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final ProductService productService = new ProductService(productRepository);
    private final List<Product> productList = new ArrayList<>(List.of(
            new Product("Serviettes imprimées", "Salle de bain", 20),
            new Product("Gant de toilette", "Salle de bain", 5),
            new Product("Gants de travail", "Bricolage", 25),
            new Product("Marteau", "Bricolage", 20),
            new Product("Tournevis", "Bricolage", 10)
    ));

    @Given("there is product in list")
    public void thereIsProductInList() {
        Mockito.when(productRepository.getAll()).thenReturn(productList);
        Assert.assertFalse(productRepository.getAll().isEmpty());
    }

    @When("user type a word {string}")
    public void userTypeAWord(String arg0) {
        search = arg0;
    }

    @Then("user receive a list of products")
    public void userReceiveAListOfProducts() {
        Mockito.when(productRepository.getAll()).thenReturn(productList);
        resultList = productService.searchByName(search);
        Assert.assertFalse(resultList.isEmpty());
    }

    @And("products match with word")
    public void productsMatchWithWord() {
        Assert.assertTrue(resultList.stream().allMatch(r -> r.getName().toLowerCase().contains(search.toLowerCase())));
    }

    @Given("there is a list of categories")
    public void thereIsAListOfCategories() {
        Mockito.when(productRepository.getAll()).thenReturn(productList);
        Assert.assertFalse(productService.getCategories().isEmpty());
    }

    @When("user select a category {string}")
    public void userSelectACategory(String arg0) {
        search = arg0;
    }

    @Then("User receive a list of products matching category")
    public void userReceiveAListOfProductsMatchingCategory() {
        resultList = productService.searchByCategory(search);
        boolean isMatching = resultList.stream().allMatch(r -> r.getCategory().equals(search));
        Assert.assertTrue(isMatching);
    }

}
