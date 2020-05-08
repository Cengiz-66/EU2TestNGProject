package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CelilAbiTestCase3 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().setPosition(new Point(500, 0));
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,20);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2_000);
        driver.quit();
    }

    @Test
    public void airbnnb() throws InterruptedException {

        driver.get("https://www.airbnb.com/");
        //**switch to page langeuage English
        WebElement languageSettings = driver.findElement(By.cssSelector("[href=\"/account-settings/language\"][class=\"_1kejnocv\"]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(languageSettings));
        languageSettings.click();
        WebElement language = driver.findElement(By.xpath("(//a[@class=\"_lwi6c1u\"])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(language)).click();

        //1  get the windowHandle for future use
        String mainPageHandle=driver.getWindowHandle();
        //2- type "new z" into the search box
        WebElement locationBox = driver.findElement(By.id("bigsearch-query-attached-query"));
        wait.until(ExpectedConditions.visibilityOf(locationBox)).sendKeys("new z");
        //3- select "New Zealand" from the list
        Thread.sleep(1000);
        List<WebElement> suggestionList = driver.findElements(By.cssSelector("._7elcsf"));
        for (WebElement element : suggestionList) {
            if(element.getText().contains("New Zealand")) {
                element.click();
                break;
            }
        }
        //4- select the date interval "May 1 to May 5
        WebElement select1date = driver.findElement(By.cssSelector("[aria-label=\"Choose Friday, May 1, 2020 as your start date. It's available.\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(select1date)).click();
        //Thread.sleep(500);
        WebElement select2date = driver.findElement(By.cssSelector("[aria-label=\"Choose Tuesday, May 5, 2020 as your end date. It's available.\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(select2date)).click();
        //5- click add guests
        WebElement guestBox = driver.findElement(By.xpath("//div[contains(text(),'Guests')]"));
       guestBox.click();
        //6a- add two adults
        WebElement addAdult = driver.findElement(By.xpath("//div[@id=\"stepper-adults\"]/button[@aria-label=\"increase value\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(addAdult)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addAdult)).click();
        //6b- add two children
        WebElement addChildren = driver.findElement(By.xpath("//div[@id=\"stepper-children\"]/button[@aria-label=\"increase value\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(addChildren)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addChildren)).click();
        //7- submit
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
        //8- click the first hotel
        Thread.sleep(2000);
        List<WebElement> hotelList = driver.findElements(By.cssSelector("[itemprop=\"itemListElement\"]"));
        //wait.until(ExpectedConditions.visibilityOfAllElements(hotelList));
        wait.until(ExpectedConditions.elementToBeClickable(hotelList.get(0))).click();
        //9- switch to new tab
        Set<String> windowHandles =  driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(mainPageHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //10- now get the second window handle - for future use
        String secondWindowHandle=driver.getWindowHandle();
        //11- get the page title and verify it contains "Zealand"
        String hotel1Title=driver.getTitle();
        //12- get the name of the 1st hotel
        String hotel1Name=driver.findElement(By.tagName("h1")).getText();
        String price=driver.findElement(By.cssSelector("._doc79r")).getText();
        //13- go back to first window
        driver.switchTo().window(mainPageHandle);
        //14- click to THIRD link (i've ignored second link because it sometimes has advertisement, makes complicated)
        wait.until(ExpectedConditions.elementToBeClickable(hotelList.get(2))).click();
        //15- go to third tab
        windowHandles =  driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(mainPageHandle)) {
                if(!windowHandle.equals(secondWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        }
        //16- now get the third window handle - for future use
        String thirdWindowHandle=driver.getWindowHandle();
        //17- get the page title and verify it contains "Zealand"
        //18- get the name of the 2nd hotel
        String hotel2Name=driver.findElement(By.xpath("//h1")).getText();
        //19- print the names of the 1st and 2nd hotel.
        System.out.println("hotel1Name = " + hotel1Name+" "+price);
        System.out.println("hotel2Name = " + hotel2Name);

    }

}
