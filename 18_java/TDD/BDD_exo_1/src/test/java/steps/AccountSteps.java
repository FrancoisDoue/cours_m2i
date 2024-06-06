package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.exercice.entity.Account;
import org.exercice.exception.ExistingUserException;
import org.exercice.exception.InvalidCredentialsException;
import org.exercice.service.AccountService;
import org.junit.Assert;

public class AccountSteps {

    AccountService accountService;
    Account account;

    @Before
    public void setUp() {
        accountService = new AccountService();
        accountService.getAccounts().add(
                new Account("user1@mail.com", "user1", "password")
        );
    }

    @Given(": user gives valid credentials")
    public void userGivesValidCredentials() {
        account = new Account("user@mail.com", "user", "password");
    }

    @When(": application registering user with success")
    public void applicationRegisteringUserWithSuccess() {
        accountService.register(account);
    }

    @Then(": account is created")
    public void accountIsCreated() {
        Assert.assertEquals(account, accountService.getAccountByMail(account.getMail()));
    }

    @Given(": user gives invalid credentials")
    public void userGivesInvalidCredentials() {
        account = new Account("user1@mail.com", "user", "password");
    }

    @When(": account is not created")
    @Then(": user have an error message")
    @And(": Existing user exception is raised")
    public void userHaveAnErrorMessage() {
        Assert.assertThrows(ExistingUserException.class, () -> accountService.register(account));
        try {
            accountService.register(account);
        } catch (ExistingUserException e) {
            Assert.assertFalse(e.getMessage().isEmpty());
        }
    }

    @Given(": user gives valid credentials for connection")
    @When(": application connect with success")
    public void applicationConnectWithSuccess() {
        account = accountService.login("user1@mail.com", "password");
        Assert.assertNotNull(account);
    }

    @Then(": user is logged")
    public void userIsLogged() {
        Assert.assertTrue(account.isLogged());
    }

    @Given(": user gives invalid credentials for connection")
    @When(": application fail to connect")
    @Then(": InvalidCredentials exception is raised")
    public void applicationFailToConnect() {
        Assert.assertThrows(
                InvalidCredentialsException.class,
                () -> accountService.login("user1@mail.com", "passWord")
        );
    }

}
