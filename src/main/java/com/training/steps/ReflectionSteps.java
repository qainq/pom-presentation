package com.training.steps;

import com.training.annotations.Label;
import com.training.annotations.PageName;
import com.training.pages.BasePage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Set;

public class ReflectionSteps {

    @Step
    public BasePage getPageByName(String pageName) throws Exception {
        Reflections reflections = new Reflections("com.training.pages.");
        Set<Class<? extends BasePage>> pageClasses = reflections.getSubTypesOf(BasePage.class);
        for (Class<? extends BasePage> clazz : pageClasses) {
            PageName clazzAnnotation = clazz.getAnnotation(PageName.class);
            if (clazzAnnotation != null && clazzAnnotation.value().equals(pageName)) {
                Constructor pageConstructor = clazz.getConstructor(WebDriver.class);
                WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
                return (BasePage) pageConstructor.newInstance(driver);
            }
        }
        return null;
    }

    public String getLabelAnnotatedValue(BasePage page, String elementName) throws IllegalAccessException {
        for (Field field : page.getClass().getDeclaredFields()) {
            Label label = field.getAnnotation(Label.class);
            if (label != null) {
                if (label.value().equals(elementName)) {
                    field.setAccessible(true);
                    return (String) field.get(page);
                }
            }
        }
        return null;
    }

}
