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
public class addLanguageStepDefs extends MyFirstMicroserviceApplication{

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
    public void categoryinit() {

        languageRepository = mock(LanguageRepository.class);

        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository);
    }


    int language_id;

    String name;


    @Given("I have the language name and id")
    public void i_have_the_language_name_and_id() {

        language_id = 3;
        name = "Mandarin";


    }

    String actual;

    @When("I input the language info into the database")
    public void i_input_the_language_info_into_the_database() {

        Language languagetest = new Language(language_id, name);
        Mockito.when(languageRepository.save(languagetest)).thenThrow(IllegalStateException.class);
        actual = myFirstMicroserviceApplication.addLanguage(language_id, name);

    }

    String expected = "New Language Saved";

    @Then("I get the success language return string")
    public void i_get_the_success_language_return_string() {

        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        Assertions.assertEquals(expected, actual);

    }
}
