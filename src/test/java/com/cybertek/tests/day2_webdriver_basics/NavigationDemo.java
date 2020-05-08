package com.cybertek.tests.day2_webdriver_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\80.0.3987.149\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");

        driver.navigate().to("https://www.facebook.com");

        //wait 3 second here then go back
        Thread.sleep(3000);
        driver.navigate().back();
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();

        String title = driver.getTitle();
        System.out.println("title = " + title);

    }
}
