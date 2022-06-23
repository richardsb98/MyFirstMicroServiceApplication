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
public class addCategoryStepDefs extends MyFirstMicroserviceApplication{

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

        categoryRepository = mock(CategoryRepository.class);

        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository);
    }


    int category_id;

    String name;

    @Given("I have the category's name and id")
    public void i_have_the_category_s_name_and_id() {

        category_id = 3;
        name = "Horror";

    }
    String actual;

    @When("I input the category info into the database")
    public void i_input_the_category_info_into_the_database() {

        Category categorytest = new Category(category_id, name);
        Mockito.when(categoryRepository.save(categorytest)).thenThrow(IllegalStateException.class);
        actual = myFirstMicroserviceApplication.addCategory(category_id, name);

    }

    String expected = "New Category Saved";
    @Then("I get the success category return string")
    public void i_get_the_success_category_return_string() {

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        Assertions.assertEquals(expected, actual);
    }


}
