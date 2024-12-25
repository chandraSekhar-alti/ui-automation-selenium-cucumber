package com.dfh.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.dfh.utils", "com.dfh.stepdefinitions", "com.dfh.pages", "com.dfh.hooks"},
        tags = "@Regression"
)
public class TestRunner {


}
