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
    public void test() {
        driver.navigate().to("http://localhost:3000/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("outlined-basic")).click();
        WebElement password = driver.findElement(By.id("outlined-basic"));
        password.sendKeys("penelope");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("actorCard1")));
//        driver.findElement(By.className("Customer")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("back")));
        //Assertions.assertEquals(By.className("Customer"),"Customer");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        WebElement newpassword = driver.findElement(By.id("actorCard1"));
        System.out.println(newpassword.getText().lines().toArray()[0]);
        Assertions.assertEquals("Id: 1 First Name:PENELOPELast Name: GUINESS", newpassword.getText());



    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @AfterAll
    static void afterAll() {

    }
}
