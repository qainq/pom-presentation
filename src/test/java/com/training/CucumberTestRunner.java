package com.training;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsons/report.json"}
        ,
        features = "src/test/resources/features"
        ,
        glue = {"com/training/stepdefinitions", "com/training/hooks"}
)
public class CucumberTestRunner {
}
