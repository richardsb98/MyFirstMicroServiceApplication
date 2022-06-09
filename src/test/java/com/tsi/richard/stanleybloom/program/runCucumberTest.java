package com.tsi.richard.stanleybloom.program;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty"},
        features = "src/test/resources/Cucumber",
        glue = "com.tsi.richard.stanleybloom.program"
)

public class runCucumberTest {
}
