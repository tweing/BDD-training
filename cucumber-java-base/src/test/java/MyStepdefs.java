import com.codurance.Account;
import com.codurance.AccountService;
import com.codurance.Printer;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs {

    AccountService sut;
    Printer printer;
    Stream outputstream;

    @Before
    public void init() {
        //outputstream = new Stream();
        printer = new Printer(outputstream);
        sut = new Account(printer);
    }

    @Given("a client makes a deposit of {int} on {int}{int}{int}")
    public void aClientMakesADepositOfOn(int amount, int day, int month, int year) {
        sut.deposit(amount);
    }

    @And("a deposit of {int} on {int}{int}{int}")
    public void aDepositOfOn(int amount, int day, int month, int year) {
        sut.deposit(amount);
    }

    @And("a withdrawal of {int} on {int}{int}{int}")
    public void aWithdrawalOfOn(int amount, int day, int month, int year) {
        sut.withdraw(amount);
    }

    @When("they print their bank statement")
    public void theyPrintTheirBankStatement() {
        sut.printStatement();
    }

    @Then("they would see {string}")
    public void theyWouldSee(String arg0) {
        // todo: assert on outputstream
        assertThat("").isEqualTo(arg0);
    }
}
