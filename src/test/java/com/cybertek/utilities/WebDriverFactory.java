package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType) {
        WebDriver driver=null;
        if(browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\81.0.4044.138\\chromedriver.exe");
           driver=new ChromeDriver();
        } else if(browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","D:\\aa\\drivers\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        return driver;
    }
}
