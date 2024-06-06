package steps;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.exercice.entity.Account;
import org.exercice.service.AccountService;
import org.junit.Assert;

public class AccountSteps {

    private static AccountService accountService;
    private Account account;

    @BeforeStep()
    public void before_or_after() {
        accountService = new AccountService();
//        accountService.getAccounts().add(
//                new Account("user@mail.fr", "user", "password")
//        );
    }

    @Given("User access to a register form")
    public void userAccessToARegisterForm() {
        account = new Account();
    }

    @When("User give mail, name and password")
    public void userGiveMailNameAndPassword() {
        account.setMail("user1@mail.fr");
        account.setUsername("user");
        account.setPassword("password");
    }

    @When("User give an existing mail, name and password")
    public void userGiveAnExistingMailNameAndPassword() {
    }

    @Then("Account is creates")
    public void accountIsCreates() {
        Assert.assertTrue(accountService.register(account));
        Assert.assertTrue(accountService.getAccounts().contains(account));
    }

    @Then("Account is not created")
    public void accountIsNotCreated() {
    }

    @And("User have a success message")
    public void userHaveASuccessMessage() {
    }

    @Then("User have an error message")
    public void userHaveAnErrorMessage() {
    }


}
