package com.training;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TestConfig {

    @Bean
    public WebDriver webDriverBean(){
        return Serenity.getDriver();
    }
}
