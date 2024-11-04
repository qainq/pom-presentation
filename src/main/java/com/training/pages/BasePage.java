package com.training.pages;

import net.serenitybdd.core.pages.PageObject;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BasePage extends PageObject {

    private String verifyXpath;


    public BasePage(){
    }

    public BasePage (WebDriver driver){
        super(driver);
    }

    public String getVerifyXpath(){
        return this.verifyXpath;
    }

    public void setVerifyXpath(String verifyXpath){
        this.verifyXpath = verifyXpath;
    }

    public boolean verify(){
        return $(verifyXpath).isDisplayed();
    }

}
