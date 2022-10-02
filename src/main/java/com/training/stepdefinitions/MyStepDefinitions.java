package com.training.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefinitions {
    @Given("User open {string} link")
    public void userOpenPage(String arg0) {
    }

    @Then("User verify page {string}")
    public void userVerifyPage(String arg0) {
        
    }

    @When("User type text {string} into field {string} on page {string}")
    public void userTypeTextIntoFieldOnPage(String arg0, String arg1, String arg2) {
    }

    @When("User click button {string} on page {string}")
    public void userClickButtonOnPage(String arg0, String arg1) {
        
    }

    @Then("User verify page {string} is opened")
    public void userVerifyPageIsOpened(String arg0) {
        
    }

    @Then("User verify element {string} is displayed on page {string}")
    public void userVerifyElementIsDisplayedOnPage(String arg0, String arg1) {
    }
}
