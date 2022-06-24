package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver =new SafariDriver();

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testFilterByActorName() {
        driver.navigate().to("http://localhost:3000/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("outlined-basic")).click();
        WebElement actortile = driver.findElement(By.id("outlined-basic"));
        actortile.sendKeys("penelope");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("actorCard1")));
//        driver.findElement(By.className("Customer")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("back")));
        //Assertions.assertEquals(By.className("Customer"),"Customer");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebElement newactortile = driver.findElement(By.id("actorCard1"));
        System.out.println(newactortile.getText().lines().toArray()[0]);
        Assertions.assertEquals("Id: 1 First Name:PENELOPELast Name: GUINESS", newactortile.getText());

    }

    @Test
    public void addToWatch() {
        driver.navigate().to("http://localhost:3001/");
        driver.findElement(By.id("towatchinput")).click();
        WebElement input = driver.findElement(By.id("towatchinput"));
        input.sendKeys("Planet Of the Apes");

        driver.findElement(By.id("addmovie")).click();

        WebElement newMovie = driver.findElement(By.id("towatchlist"));
        System.out.println(newMovie.getText().lines().toArray()[0]);
        Assertions.assertEquals("Planet Of the Apes", newMovie.getText());
    }


    @Test
    public void removeToWatch() {
        driver.navigate().to("http://localhost:3001/");
        driver.findElement(By.id("towatchinput")).click();
        WebElement input = driver.findElement(By.id("towatchinput"));
        input.sendKeys("Planet of the Apes 2");

        driver.findElement(By.id("addmovie")).click();

        driver.findElement(By.id("towatchlist")).click();

        driver.findElement(By.id("removewatched")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("towatchlist")));

        Assertions.assertEquals(true, input.isDisplayed());

    }

    @Test
    public void testFilterByFilmName() {
        driver.navigate().to("http://localhost:3001/");
        driver.findElement(By.id("outlined-basic")).click();
        WebElement filmtile = driver.findElement(By.id("outlined-basic"));
        filmtile.sendKeys("star operation");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filmCard841")));
        WebElement newfilmtile = driver.findElement(By.id("filmCard841"));
        System.out.println(newfilmtile.getText().lines().toArray()[0]);
        Assertions.assertEquals("Id: 841 Title: STAR OPERATIONRunning Length: 181Release Year: 2006Age Rating: PG", newfilmtile.getText());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @AfterAll
    static void afterAll() {

    }
}
