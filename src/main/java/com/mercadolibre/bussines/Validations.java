package com.mercadolibre.bussines;

import com.mercadolibre.utils.WaitsHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Validations {

    public static boolean isDisplayedWebElement(WebElement element, WebDriver driver){
        return new WaitsHelpers(driver).waitForElementByWebElement(element, Duration.ofSeconds(10), Duration.ofSeconds(3)).isDisplayed();
    }
}
