package com.training.stepdefinitions;

import com.training.TestConfig;
import com.training.exceptions.LocatorNotFoundException;
import com.training.exceptions.PageNotFoundException;
import com.training.pages.BasePage;
import com.training.steps.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

//@ContextConfiguration(classes = TestConfig.class)
public class MyStepDefinitions {

    @Autowired
    private List<BasePage> pages;
    @Autowired
    private PageSteps pageSteps;

    @Given("User open {string} link")
    public void userOpenPage(String link) {
        Serenity.getDriver().get(link);
    }

    @When("User type text {string} into field {string} on page {string}")
    public void userTypeTextIntoFieldOnPage(String text, String locatorName, String pageName) throws PageNotFoundException, LocatorNotFoundException, IllegalAccessException {
        BasePage page = pageSteps.getPageByName(pageName);
        String locator = pageSteps.getLocator(page, locatorName);
        pageSteps.typeTextIntoField(page, locator, text);
    }

    @When("User click button {string} on page {string}")
    public void userClickButtonOnPage(String locatorName, String pageName) throws PageNotFoundException, LocatorNotFoundException, IllegalAccessException {
        BasePage page = pageSteps.getPageByName(pageName);
        String locator = pageSteps.getLocator(page, locatorName);
        pageSteps.clickButton(page, locator);
    }

    @Then("User verify page {string} is opened")
    public void userVerifyPageIsOpened(String pageName) throws PageNotFoundException {
        Assertions.assertThat(pageSteps.getPageByName(pageName))
                .as(pageName + " page is not opened")
                .matches(BasePage::verify);
    }
}
