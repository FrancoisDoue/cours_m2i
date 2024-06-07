package steps;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bdd_exo_1.entity.Account;
import org.bdd_exo_1.repository.impl.AccountRepository;
import org.bdd_exo_1.service.AccountService;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;

public class AccountSteps {
    private Account account;
    private AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    private AccountService accountService;
    List<Account> accountList = List.of(
            new Account("user1@mail.fr", "user1", "password")
    );

    @Before
    public void before() {
        accountService = new AccountService(accountRepository);
        Mockito.when(accountRepository.getAll()).thenReturn(accountList);
    }

    @Given(": user gives valid credentials")
    public void userGivesValidCredentials() {
        account = new Account("user@mail.fr", "user", "password");
    }

    @When(": application registering user with success")
    public void applicationRegisteringUserWithSuccess() {
        accountService.register(account);
    }

    @BeforeStep public void beforeStep() {
        accountList.add(account);
    }
    @Then(": account is created")
    public void accountIsCreated() {
        Assert.assertEquals(account, accountService.getAccount(account.getEmail()));
    }

    @Given(": user gives invalid credentials")
    public void userGivesInvalidCredentials() {
        Assert.assertEquals(account, accountService.getAccount(account.getEmail()));
    }

    @When(": account is not created")
    public void accountIsNotCreated() {
    }

    @Then(": user have an error message")
    public void userHaveAnErrorMessage() {
    }

    @And(": Existing user exception is raised")
    public void existingUserExceptionIsRaised() {
    }

    @Given(": user gives valid credentials for connection")
    public void userGivesValidCredentialsForConnection() {
    }

    @When(": application connect with success")
    public void applicationConnectWithSuccess() {
    }

    @Then(": user is logged")
    public void userIsLogged() {
    }

    @Given(": user gives invalid credentials for connection")
    public void userGivesInvalidCredentialsForConnection() {
    }

    @When(": application fail to connect")
    public void applicationFailToConnect() {
    }

    @Then(": InvalidCredentials exception is raised")
    public void invalidcredentialsExceptionIsRaised() {
    }
}
