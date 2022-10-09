package com.training.stepdefinitions;

import com.training.pages.GoogleSearchPage;
import com.training.pages.WikiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyStepDefinitions {

    @Given("The user opens {string} link")
    public void theUserOpensLink(String link) {
        WebDriver driver = Serenity.getDriver();
        driver.get(link);
    }

    @When("The page Google Search is opened")
    public void theGoogleSearchPageIsOpened() {
        WebDriver driver = Serenity.getDriver();
        GoogleSearchPage page = new GoogleSearchPage(driver);
        Assert.assertTrue("Google Search page was not opened!!!!", page.verify());
    }

    @When("The user types the text {string} into the Search Field on the Google Search page")
    public void theUserTypesTheTextIntoTheSearchFieldOnTheGoogleSearchPage(String text) {
        WebDriver driver = Serenity.getDriver();
        GoogleSearchPage page = new GoogleSearchPage(driver);
        String locator = page.getSearchInputField();
        page.$(locator).type(text);
    }

    @When("The user clicks the Search Button on the Google Search page")
    public void theUserClicksTheButtonOnTheGoogleSearchPage() {
        WebDriver driver = Serenity.getDriver();
        GoogleSearchPage page = new GoogleSearchPage(driver);
        String locator = page.getSearchButton();
        page.$(locator).waitUntilClickable().click();
    }

    @When("The user clicks the First Result button on the Google Search page")
    public void theUserClicksTheFirstResultButtonOnTheGoogleSearchPage() {
        WebDriver driver = Serenity.getDriver();
        GoogleSearchPage page = new GoogleSearchPage(driver);
        String locator = page.getTheFirstSearchResults();
        page.$(locator).waitUntilClickable().click();
    }

    @Then("The user verifies that the page Wiki is opened")
    public void theUserVerifiesThatThePageWikiIsOpened() {
        WebDriver driver = Serenity.getDriver();
        WikiPage page = new WikiPage(driver);
        Assert.assertTrue("Wiki page was not opened!!!!", page.verify());
    }

    @Then("The user verifies that the element First Header value on the page Wiki is equal to {string}")
    public void theUserVerifiesThatTheElementValueOnThePageWikiIsEqualTo(String expectedValue) {
        WebDriver driver = Serenity.getDriver();
        WikiPage page = new WikiPage(driver);
        String locator = page.getFirstHeader();
        String actualValue = page.$(locator).getText();
        Assert.assertEquals(expectedValue, actualValue);
    }

}
