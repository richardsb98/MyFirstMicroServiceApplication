package com.tsi.richard.stanleybloom.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class addFilmtoListStepDefs {


    WebDriver driver =new SafariDriver();
    @Given("I have the film title")
    public void i_have_the_film_title() {

        driver.navigate().to("http://localhost:3000/");
    }
    @When("I input the name and click the Add Movie To Watch button")
    public void i_input_the_name_and_click_the_add_movie_to_watch_button() {


        driver.findElement(By.id("towatchinput")).click();
        WebElement title = driver.findElement(By.id("outlined-basic"));
        driver.findElement(By.id("addmovie"));
    }
    @Then("The film title is displayed into the list")
    public void the_film_title_is_displayed_into_the_list() {


        String expected = "TestMovie";
        WebElement password = driver.findElement(By.id("towatchinput"));
        Assertions.assertEquals(expected, password.getText());


    }
}
