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
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class AccountSteps {
    private Account account;
    private AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    private AccountService accountService = new AccountService(accountRepository);

    private List<Account> accountList = new ArrayList<>(List.of(
            new Account("user1@mail.fr", "user1", "password")
    ));

    @Given(": user gives valid credentials")
    public void userGivesValidCredentials() {
        account = new Account("user@mail.fr", "user", "password");
    }

    @When(": application registering user with success")
    public void applicationRegisteringUserWithSuccess() {
        Mockito.when(accountRepository.getAll()).thenReturn(accountList);
        accountService.register(account);
    }

    @Then(": account is created")
    public void accountIsCreated() {
        accountList.add(account);
        Mockito.when(accountRepository.getAll()).thenReturn(accountList);
        Assert.assertEquals(account, accountService.getAccount(account.getEmail()));
    }


    @Given(": user gives valid credentials {string} {string} for connection")
    public void userGivesValidCredentialsForConnection(String arg0, String arg1) {
        account = new Account();
        account.setEmail(arg0);
        account.setPassword(arg1);
    }

    @When(": application connect with success")
    public void applicationConnectWithSuccess() {
        Mockito.when(accountRepository.getAll()).thenReturn(accountList);
        account = accountService.login(account.getEmail(), account.getPassword());
        Assert.assertEquals(account, accountList.get(0));
    }

    @Then(": user is logged")
    public void userIsLogged() {
        Assert.assertTrue(account.isLogged());
    }
}
