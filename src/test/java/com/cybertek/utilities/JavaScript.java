package com.cybertek.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript {

    //click with JavaScriptExecutor
    public static JavascriptExecutor clickWithJSE(WebDriver driver, WebElement element) {
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",element);
        return jse;
    }

    //type with JavaScriptExecutor it doesn't matter enable or not
    public static JavascriptExecutor typeWithJSE(WebDriver driver, WebElement element,String string) {
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + string +"')",element);
        return jse;
    }

}
