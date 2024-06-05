import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.exercice.Account;
import org.junit.Assert;

public class AccountSteps {

    private Account account;

    @Given("user haven't account")
    public void userHavenTAccount() {
        account = new Account();
    }

    @When("user give username and password")
    public void userGiveUsernameAndPassword() {
        account.setUsername("username");
        account.setPassword("password");
    }

    @Then("there is a new account with credentials")
    public void thereIsANewAccount() {
        Assert.assertEquals("username", account.getUsername());
    }

}
