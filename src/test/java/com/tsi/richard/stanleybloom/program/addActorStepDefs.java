package com.tsi.richard.stanleybloom.program;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentCaptor;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class addActorStepDefs extends MyFirstMicroserviceApplication {

    private static MyFirstMicroserviceApplication myFirstMicroserviceApplication;

    @Mock
    private ActorRepository actorRepository;

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private LanguageRepository languageRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void init() {
        actorRepository = mock(ActorRepository.class);

        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository);
    }

    String firstname;
    String lastname;

    @Given("I have the actor information")
    public void i_have_the_actor_information() {

        firstname = "Penelope";
        lastname = "Guiness";

    }
    String actual;

    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {

    Actor actortest = new Actor(firstname, lastname);
    Mockito.when(actorRepository.save(actortest)).thenThrow(IllegalStateException.class);
    actual = myFirstMicroserviceApplication.addActor(firstname, lastname);

    }

    String expected = "New Actor Saved";
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {


        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.capture();
        Assertions.assertEquals(expected, actual);
    }
}
