package com.training.pages;

import com.training.annotations.Locator;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WikiPage extends BasePage {

    @Locator("Wikipedia Banner")
    private String wikiMainBannerLocator = "//div[@role='banner']/a";

    @Locator("First Header")
    private String theFirstHeaderLocator = "//*[@id='firstHeading']/span[1]";

    @Locator("First Headline")
    private String theFirstHeadlineLocator = "//*[contains(@*,'mw-heading mw-heading1')]";

    @Autowired
    public WikiPage(WebDriver driver) {
        super(driver);
        setVerifyXpath(wikiMainBannerLocator);
    }

    public WikiPage() {
        System.out.println("hello WikiPage");
    }
}
