package com.training.stepdefinitions;

import com.training.pages.BasePage;
import com.training.steps.BaseSteps;
import com.training.steps.ReflectionSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class MyStepDefinitions {

    @Steps
    private BaseSteps baseSteps;

    @Steps
    private ReflectionSteps reflectionSteps;

    @Given("The user opens {string} link")
    public void theUserOpensLink(String link) {
        baseSteps.browserGetPageByLink(link);
    }

    @When("The user types the text {string} into the field {string} on the {string} page")
    public void theUserTypesTheTextIntoTheFieldOnThePage(String text, String fieldName, String pageName) throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getLabelAnnotatedValue(page, fieldName);
        baseSteps.typeTextIntoField(page, locator, text);
    }

    @When("The user clicks the button {string} on {string} page")
    public void theUserClicksTheButtonOnPage(String buttonName, String pageName) throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getLabelAnnotatedValue(page, buttonName);
        baseSteps.clickButton(page, locator);
    }

    @Then("The user verifies that the page {string} is opened")
    public void theUserVerifiesThatThePageIsOpened(String pageName) throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        Assert.assertTrue(String.format("The page %s was not opened !!!", pageName), page.verify());
    }

    @Then("The user verifies that the element {string} value on the page {string} is equal to {string}")
    public void theUserVerifiesThatTheElementValueOnThePageIsEqualTo(String elementName, String pageName, String expectedValue) throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getLabelAnnotatedValue(page, elementName);
        String actualValue = baseSteps.getElementText(page, locator);
        Assert.assertEquals(expectedValue, actualValue);
    }
}
