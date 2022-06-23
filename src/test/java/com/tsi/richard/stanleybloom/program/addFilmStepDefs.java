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
public class addFilmStepDefs extends MyFirstMicroserviceApplication {

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
    public void filminit() {

        filmRepository = mock(FilmRepository.class);

        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository);
    }

    String title;
    int length;
    int release_year;
    String rating;

    int film_id;

    int language_id;

    @Given("I have the film information")
    public void i_have_the_film_information() {

        film_id = 220;
        title = "Planet Of The Apes";
        length = 120;
        release_year = 2016;
        rating = "PG-13";
        language_id = 1;

    }
    String actual;

    @When("I input the film data into the database")
    public void i_input_the_film_data_into_the_database() {

        Film filmtest = new Film(film_id, title, length, release_year, rating, language_id);
        Mockito.when(filmRepository.save(filmtest)).thenThrow(IllegalStateException.class);
        actual = myFirstMicroserviceApplication.addFilm(film_id, title, length, release_year, rating, language_id);

    }

    String expected = "New Film Saved";
    @Then("I get the success film return string")
    public void i_get_the_success_film_return_string() {


        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        Assertions.assertEquals(expected, actual);
    }
}
