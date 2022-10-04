package com.training.pages;

import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

public class BasePage extends PageObject {

    @Getter
    @Setter
    private String verifyXpath;

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public boolean verify() {
        return $(verifyXpath).isDisplayed();
    }

    public Optional<WebElement> getElement(String xpathLocator, long durationSeconds){
        WebDriverWait wait = new WebDriverWait(this.getDriver(), Duration.ofSeconds(1));
        WebElement element = wait.pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(durationSeconds))
                .ignoring(TimeoutException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)))
                .findElement(By.xpath(xpathLocator));
        return Optional.ofNullable(element);
    }

}
