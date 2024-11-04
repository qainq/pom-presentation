package com.training.pages;

import com.training.annotations.Locator;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class GoogleSearchPage extends BasePage {

    @Locator("Search Button")
    private String searchButtonXpath = "//*[@name='btnK']";

    @Locator("Search Field")
    private String searchFieldXpath = "(//*[@name='q'])";

    @Locator("The First Result")
    private String theFirstResultXpath = "(//div[@id='search']//a)[1]";

    @Autowired
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        setVerifyXpath(searchButtonXpath);
    }

    @Override
    public boolean verify() {
        return $(this.getVerifyXpath()).isPresent();
    }
}
