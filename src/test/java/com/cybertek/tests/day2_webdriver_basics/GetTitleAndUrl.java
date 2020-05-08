package com.cybertek.tests.day2_webdriver_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\80.0.3987.149\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com/ap/sign");
        //getting title with selenium
        String title = driver.getTitle();
        System.out.println("title = " + title);
        //current url of the page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //String pageSource = driver.getPageSource();
       // System.out.println("pageSource = " + pageSource);

       // driver.close();

    }
}
