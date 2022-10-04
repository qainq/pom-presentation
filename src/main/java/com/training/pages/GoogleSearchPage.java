package com.training.pages;

import com.training.annotations.Label;
import com.training.annotations.PageName;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
@PageName("Google Search")
public class GoogleSearchPage extends BasePage{

    @Label("Search Field")
    private String searchInputField = "//input[@title='Пошук']";//"//input[@name='q']"

    @Label("Search Button")
    private String searchButton = "//input[@value='Пошук Google']";//"//input[@type='text']"

    @Label("The First Result")
    private String searchResults = "//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div/a";

    public GoogleSearchPage(WebDriver driver){
        super(driver);
        setVerifyXpath(searchButton);
    }

    @Override
    public boolean verify(){
        return $(this.getVerifyXpath()).isPresent();
    }

}
