package com.training.pages;

import com.training.annotations.Label;
import com.training.annotations.PageName;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
@PageName("Wiki")
public class WikiPage extends BasePage{
    @Label("Wikipedia Banner")
    private String goToTheMainPageBanner = "//div[@role='banner']/a";

    @Label("First Header")
    private String firstHeader = "//*[@id='firstHeading']/span[1]";

    public WikiPage(WebDriver driver){
        super(driver);
        setVerifyXpath(goToTheMainPageBanner);
    }

}
