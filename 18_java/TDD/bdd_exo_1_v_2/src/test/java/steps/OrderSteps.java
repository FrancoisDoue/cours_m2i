package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bdd_exo_1.entity.Account;
import org.bdd_exo_1.entity.Order;
import org.bdd_exo_1.entity.Product;
import org.bdd_exo_1.repository.impl.AccountRepository;
import org.bdd_exo_1.repository.impl.OrderRepository;
import org.bdd_exo_1.repository.impl.ProductRepository;
import org.bdd_exo_1.service.AccountService;
import org.bdd_exo_1.service.OrderService;
import org.bdd_exo_1.service.ProductService;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OrderSteps {

    private Account account;
    private Order order;

    private final AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final OrderRepository orderRepository = Mockito.mock(OrderRepository.class);

    private final AccountService accountService = new AccountService(accountRepository);
    private final OrderService orderService = new OrderService(
            new AccountService(accountRepository),
            new ProductService(productRepository),
            orderRepository
    );

    private final List<Product> productList = new ArrayList<>(List.of(
            new Product("Serviettes imprimées", "Salle de bain", 20),
            new Product("Gant de toilette", "Salle de bain", 5),
            new Product("Gants de travail", "Bricolage", 25),
            new Product("Marteau", "Bricolage", 20),
            new Product("Tournevis", "Bricolage", 10)
    ));
    private final List<Account> accountList = new ArrayList<>(List.of(
            new Account("user1@mail.fr", "user1", "password")
    ));

    @Before
    public void before() {
        Mockito.when(accountRepository.getAll()).thenReturn(accountList);
        Mockito.when(productRepository.getAll()).thenReturn(productList);
        account = accountService.login("user1@mail.fr", "password");
    }

    @Given("user create a new empty order")
    public void userCreateANewEmptyOrder() {
        order = orderService.createOrder(account);
    }

    @And("user must be logged")
    public void userMustBeLogged() {
        Assert.assertTrue(order.getAccount().isLogged());
    }

    @When("user select a product")
    public void userSelectAProduct() {
        order.addProduct(productList.get(0));
    }

    @Then("product is added to his order")
    public void productIsAddedToHisOrder() {
        Assert.assertEquals(productList.get(0), order.getProducts().get(0));
        Assert.assertEquals(20, order.getTotalPrice(), 0.0);
    }

    @Given("user have an order with products")
    public void userHaveAnOrderWithProducts() {
        userCreateANewEmptyOrder();
        userSelectAProduct();
        Assert.assertFalse(order.getProducts().isEmpty());
    }

    @When("user select a product from order")
    public void userSelectAProductFromOrder() {
        Product product = order.getProducts().get(0);
        order.removeProduct(product);
    }

    @Then("product is removed from order")
    public void productIsRemovedFromOrder() {
        Assert.assertFalse(order.getProducts().contains(productList.get(0)));
    }

    @And("order cost is updated")
    public void orderCostIsUpdated() {
        Assert.assertEquals(0, order.getTotalPrice(), 0.0);
    }
//
//    @Given("user have un order with product")
//    public void userHaveUnOrderWithProduct() {
//    }
//
//    @When("user valid order")
//    public void userValidOrder() {
//    }
//
//    @Then("Order is validate")
//    public void orderIsValidate() {
//    }
//
//    @And("user receive a confirmation message")
//    public void userReceiveAConfirmationMessage() {
//    }
}
