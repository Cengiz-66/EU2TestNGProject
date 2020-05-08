package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class celilAbiTestCase {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/");
        //pop up selection****************************
        driver.findElement(By.xpath("//button[@data-gdpr-single-choice-accept]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[.='Alles klar']")).click();

        //change site language**************************
        driver.findElement(By.xpath("//button[@class=\"wt-btn wt-btn--transparent wt-btn--transparent-flush-left wt-btn--transparent-flush-right  wt-btn--light  wt-btn--small\"]")).click();
        Select dropdown=new Select(driver.findElement(By.xpath("//*[@name=\"language_code\"]")));
        Thread.sleep(2000);
        dropdown.selectByValue("en-US");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name=\"save\"]")).click();

        Thread.sleep(2000);
        //search box ******************************
        WebElement searchBox=driver.findElement(By.xpath("//input[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("selenium");
        //search box button find and click it*************
        driver.findElement(By.xpath("//button[@data-id=\"gnav-search-submit-button\"]")).click();
        Thread.sleep(3000);
        //select free shipping ******************************
        driver.findElement(By.xpath("//label[.=\"FREE shipping\"]")).click();
        Thread.sleep(2000);
        //enter min and max price ******************************
        driver.findElement(By.id("search-filter-min-price-input")).sendKeys("10");
        driver.findElement(By.id("search-filter-max-price-input")).sendKeys("25");
        Thread.sleep(1000);
        //search button for min and max price ******************************
        driver.findElement(By.xpath("//button[@class=\"wt-btn wt-btn--transparent wt-btn--icon price-submit\"]")).click();
       //get the test result ******************************
        String testResult=driver.findElement(By.xpath("//span[@class=\"wt-text-caption wt-text-link-no-underline\"]")).getText();
        //click the sort by button ******************************
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class=\"wt-menu__trigger wt-btn wt-btn--small wt-btn--transparent\"]")).click();
       //click and select the sort by price ascending ******************************
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@data-sort-by-price_asc]")).click();
        //get the first and second product ******************************
        String[] list=new String[2];
        System.out.println("First test result: ");
        System.out.println(testResult);
        System.out.println(list[0]=driver.findElement(By.xpath("//li//a[@data-position-num=\"1\"]//div//h2")).getText());
        System.out.println(list[1]=driver.findElement(By.xpath("//li//a[@data-position-num=\"2\"]//div//h2")).getText());
        Thread.sleep(1000);
        //close free shipping selection ******************************
       driver.findElement(By.xpath("(//div[@class=\"tag-close\"])[2]")).click();
        //get the test result and first-second product again ******************************
        System.out.println("Second test result: ");
        System.out.println(driver.findElement(By.xpath("//span[@class=\"wt-text-caption wt-text-link-no-underline\"]")).getText());
        System.out.println(list[0] = driver.findElement(By.xpath("//*[@id=\"content\"]//li[1]/div/a//div//h2")).getText());
        System.out.println(list[1] = driver.findElement(By.xpath("//*[@id=\"content\"]//li[2]/div/a//div//h2")).getText());
        Thread.sleep(2000);

        driver.quit();


    }
}
