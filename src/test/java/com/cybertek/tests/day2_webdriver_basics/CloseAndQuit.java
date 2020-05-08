package com.cybertek.tests.day2_webdriver_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\80.0.3987.149\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
      //driver.get("http://practice.cybertekschool.com");
      //wait 2 seconds
      Thread.sleep(2000);

      //close the current tab/window
      driver.close();

      driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        //close all tabs doesnt matter one or more
       // driver.quit();
        driver.close();
    }
    }

