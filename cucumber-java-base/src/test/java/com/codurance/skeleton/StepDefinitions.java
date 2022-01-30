package com.codurance.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    Belly belly = new Belly();

    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        belly.eat(cukes);
    }

    @When("I wait {int} hour")
    public void iWaitHour(int hours) {
        belly.iWait(hours);
    }

    @Then("my belly should growl")
    public void myBellyShouldGrowl() {
        assertEquals(belly.hasGrowled(), true);
    }
}
