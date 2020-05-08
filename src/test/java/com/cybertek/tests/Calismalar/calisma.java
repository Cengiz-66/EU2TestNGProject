package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.annotations.*;

public class calisma {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testcelilAbi() throws InterruptedException {
        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);
        WebElement acceptBtn=driver.findElement(By.cssSelector("button[class=\"width-full btn btn-outline btn-outline-black\"]"));
        acceptBtn.click();
        WebElement understandBtn=driver.findElement(By.cssSelector("[class='btn btn-outline btn-outline-black strong']"));
        understandBtn.click();
        Thread.sleep(2000);
        //switch the language of the page to English
        driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--transparent wt-btn--transparent-flush-left wt-btn--transparent-flush-right  wt-btn--light  wt-btn--small']")).click();
        Thread.sleep(3000);
        Select languageType=new Select(driver.findElement(By.cssSelector("[name=\"language_code\"]")));
        languageType.selectByVisibleText("English (US)");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#locale-overlay-save")).click();
        Thread.sleep(3000);
        Thread.sleep(3000);

        WebElement searchBox=driver.findElement(By.cssSelector("input[placeholder=\"Search for items or shops\"]"));
        searchBox.sendKeys("selenium");
        driver.findElement(By.cssSelector("button[data-id='gnav-search-submit-button']")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//label[.=\"FREE shipping\"]")).click();
        //driver.findElement(By.cssSelector("a[class=\"checkbox-label active wt-display-block\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#search-filter-min-price-input")).sendKeys("10");
        driver.findElement(By.cssSelector("#search-filter-max-price-input")).sendKeys("35");
        driver.findElement(By.cssSelector("button[data-context=\"price\"]")).click();
        Thread.sleep(4000);

        driver.findElement(By.cssSelector("button[class=\"wt-menu__trigger wt-btn wt-btn--small wt-btn--transparent\"]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(text(),\"Lowest Price\")]")).click();
        Thread.sleep(4000);
        String a=driver.findElement(By.cssSelector("span[class=\"wt-text-caption wt-text-link-no-underline\"]")).getText();
        System.out.println(driver.findElement(By.xpath("(//a[@data-marketplace=\"1\"])[1]//h2")).getText());
        System.out.println(driver.findElement(By.xpath("(//a[@data-marketplace=\"1\"])[2]//h2")).getText());
        driver.findElement(By.xpath("//div[contains(text(),\"FREE shipping\")]/../div[2]")).click();
        Thread.sleep(4000);
        System.out.println(driver.findElement(By.cssSelector("span[class=\"wt-text-caption wt-text-link-no-underline\"]")).getText());
        System.out.println(driver.findElement(By.xpath("(//a[@data-marketplace=\"1\"])[1]//h2")).getText());
        System.out.println(driver.findElement(By.xpath("(//a[@data-marketplace=\"1\"])[2]//h2")).getText());
        a=a.replace("(","").replace(")","");
        String []b=a.split(" ");
        int n=Integer.parseInt(b[0]);
        System.out.println(n);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
