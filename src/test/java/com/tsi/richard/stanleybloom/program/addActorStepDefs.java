package com.tsi.richard.stanleybloom.program;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class addActorStepDefs extends MyFirstMicroserviceApplication {

    Actor testActor = new Actor("first_name", "last_name");

    public addActorStepDefs(ActorRepository actorRepository) {
        super(actorRepository);
    }

    @Given("I have the actor information")
    public void i_have_the_actor_information() {

        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {

        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {

        // Only place to put Assertions
        Assertions.assertEquals("saved", SuccessfullAddActor, "push was not successful");
        throw new io.cucumber.java.PendingException();
    }
}
