package com.training.steps;

import com.training.pages.BasePage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    @Step
    public void browserGetPageByLink(String link) {
        WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
        driver.get(link);
    }

    @Step
    public void typeTextIntoField(BasePage page, String locator, String text) {
        page.$(locator).type(text);
    }

    @Step
    public void clickButton(BasePage page, String locator) {
        page.$(locator).waitUntilClickable();
        page.$(locator).click();
    }

    @Step
    public String getElementText(BasePage page, String locator) {
        return page.$(locator).getText();
    }
}
