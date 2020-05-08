package com.cybertek.tests.day1_intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    public static void main(String[] args) {
        System.out.println("test");

        //WebDriverManager.chromedriver().setup();

        //WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\80.0.3987.149\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","D:\\aa\\drivers\\geckodriver.exe");

       // WebDriver new1= new FirefoxDriver();
       //WebDriver new2= new ChromeDriver();
        Faker fake=new Faker();

        String fake1=fake.finance().iban();
        System.out.println("fake1 = " + fake1);

        //neww.manage().window().maximize();
        //neww.manage().deleteAllCookies();
       //new1.get("https://www.amazon.com");
       // new2.get("https://www.amazon.com");

       // System.out.println("sayfanin title i "+new1.getTitle());
       // System.out.println("sayfanin title i "+new2.getTitle());
        //new1.close();

    }
}
