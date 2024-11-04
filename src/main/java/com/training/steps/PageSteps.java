package com.training.steps;

import com.training.annotations.Locator;
import com.training.exceptions.LocatorNotFoundException;
import com.training.exceptions.PageNotFoundException;
import com.training.pages.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class PageSteps {

    @Autowired
    private List<BasePage> pages;

    public BasePage getPageByName(String pageName) throws PageNotFoundException {
        return pages.stream()
                .filter(p -> p.getClass().getSimpleName().equals(pageName))
                .findFirst().orElseThrow(PageNotFoundException::new);
    }

    public String getLocator(BasePage page, String locatorName) throws IllegalAccessException, LocatorNotFoundException {
        for (Field field : page.getClass().getDeclaredFields()) {
            Locator label = field.getAnnotation(Locator.class);
            if (label != null && label.value().equals(locatorName)) {
                field.setAccessible(true);
                return (String) field.get(page);
            }
        }
        throw new LocatorNotFoundException();
    }

    public void typeTextIntoField(BasePage page, String locator, String text) {
        page.$$(locator).stream()
                .filter(e -> e.waitUntilEnabled().isDisplayed())
                .findFirst().orElseThrow(() -> new NoSuchElementException(locator + "is not visible"))
                .type(text);
    }

    public void clickButton(BasePage page, String locator) {
        page.$$(locator).stream()
                .filter(e -> e.isVisible() && e.isClickable())
                .findFirst().orElseThrow(() -> new NoSuchElementException(locator + "is not clickable or visible"))
                .click();
    }

    public String getElementText(BasePage page, String locator) {
        return page.$(locator).getText();
    }

}
