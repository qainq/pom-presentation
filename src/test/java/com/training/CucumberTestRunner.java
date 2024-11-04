package com.training;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

//@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(
//        plugin = {"pretty", "json:target/jsons/report.json"}
//        ,
//        features = "src/test/resources/features"
//        ,
//        glue = {"com/training/stepdefinitions", "com/training/hooks"}
//)
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.training.stepdefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty,html:target/cucumber-reports.html,json:target/jsons/report.json")
public class CucumberTestRunner {
}
