package com.training;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsons/report.json", "html:target/cucumber-reports.html"}
        ,
        features = "src/test/resources/features"
        ,
        glue = {"com/training/stepdefinitions"}
)
public class CucumberTestRunner {
}
