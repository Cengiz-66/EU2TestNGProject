package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.JavaScript;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalismaVyTrack {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUP() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys(ConfigurationReader.get("driver_username"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password"));
        driver.findElement(By.id("_submit")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       // Thread.sleep(2000);
       Driver.closeDriver();
    }

    @Test
    public void test1_DragDrop() throws InterruptedException {

        WebElement loaderFrame = driver.findElement(By.cssSelector("[class=\"loader-frame\"]"));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));

        //go to fleet and vehicles and click
        WebElement fleet = driver.findElement(By.cssSelector(".title.title-level-1"));
        actions.moveToElement(fleet).pause(1).perform();
        WebElement vehicles = driver.findElement(By.xpath("(//span[contains(text(),'Vehicles')])[1]"));
        wait.until(ExpectedConditions.visibilityOf(vehicles));
        actions.moveToElement(vehicles).click().perform();
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));

        //click the second car
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).click();
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        Thread.sleep(3000);

        //click add event
        WebElement addEventButton = driver.findElement(By.xpath("//*[.='Add Event']"));
        JavaScript.clickWithJSE(driver,addEventButton);
        Thread.sleep(2000);


        //fill in the name organization email and save fields
        driver.findElement(By.name("oro_calendar_event_form[title]")).sendKeys("event title automated by me");
        WebElement redColor = driver.findElement(By.xpath("(//*[@class=\"color\"])[9]"));
        actions.moveToElement(redColor).click().perform();
        driver.findElement(By.name("oro_calendar_event_form[organizerDisplayName]")).sendKeys("organizer name here");
        driver.findElement(By.name("oro_calendar_event_form[organizerEmail]")).sendKeys("a@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();


    }

    @Test
    public void test2() throws InterruptedException {
        //go to https://qa1.vytrack.com/user/login page and login
        //We can use ConfigurationReader and new Driver Utulities***
        WebElement loaderFrame = driver.findElement(By.cssSelector("[class=\"loader-frame\"]"));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        //click the Fleet
        WebElement fleet = driver.findElement(By.cssSelector(".title.title-level-1"));
        actions.moveToElement(fleet).perform();
        //click the Vehicle Costs
        WebElement costs = driver.findElement(By.xpath("(//span[@class=\"title title-level-2\"])[3]"));
        wait.until(ExpectedConditions.visibilityOf(costs));
        actions.moveToElement(costs).click().perform();
        loaderFrame=driver.findElement(By.xpath("(//*[@class=\"loader-frame\"])[2]"));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        //click create Vehicle costs (right upper side)
        WebElement createCosts = driver.findElement(By.cssSelector("[title=\"Create Vehicle Costs\"]"));
        actions.moveToElement(createCosts).click().perform();
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        //click Type and select Tax Roll
        WebElement clickType = driver.findElement(By.cssSelector("[class=\"select2-chosen\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(clickType));
        actions.moveToElement(clickType).click().perform();
        List<WebElement> costType = driver.findElements(By.cssSelector("[class=\"select2-result-label\"]"));

        for (WebElement type : costType) {
            if(type.getText().contains("Tax Roll")) {
                actions.moveToElement(type).click().perform();
                break;
            }
        }
        //click total price and send a price
        driver.findElement(By.cssSelector("[data-name=\"field__total-price\"]")).sendKeys("100");
        //click date and select Today
        WebElement date = driver.findElement(By.cssSelector("[placeholder=\"Choose a date\"]"));
        actions.moveToElement(date).click().perform();
        driver.findElement(By.cssSelector("[data-handler=\"today\"]")).click();
        //click Cost Description and write somthing
        driver.findElement(By.cssSelector("[data-name=\"field__cost-descriptions\"]")).sendKeys("Tax Roll");
        //click save and roll
        WebElement saveClose = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        actions.moveToElement(saveClose).click().perform();
        //click again Fleet and select Vehicle Costs
        actions.moveToElement(fleet).perform();
        wait.until(ExpectedConditions.visibilityOf(costs));
        actions.moveToElement(costs).click().perform();
        //click View Per Page and select 100
        WebElement viewPerPage = driver.findElement(By.xpath("(//div[@class=\"btn-group\"])[3]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(viewPerPage));
        actions.moveToElement(viewPerPage).click().perform();
        WebElement s100=driver.findElement(By.xpath("(//*[@class=\"dropdown-item\"])[4]"));
        String str=s100.getText();
        int size=Integer.parseInt(str);
        System.out.println("size = " + size);
        wait.until(ExpectedConditions.visibilityOf(s100));
        actions.moveToElement(s100).click().perform();
        double price=0;
        Thread.sleep(3000);
        //get the all price from Vehicle costs and print them
        //also parse all of them, calculate and print the total price
      List<WebElement> elements = driver.findElements(By.xpath("(//tbody)[1]/tr/td[1]"));

        for (int i = 1; i <=size ; i++) {

                String path="(//tbody)[1]/tr["+i+"]/td["+2+"]";
                WebElement cell=driver.findElement(By.xpath(path));
                if(!cell.getText().isEmpty()) {
                    String list = cell.getText().replace("$", "").replace(",","");
                    if(Double.valueOf(list)>=0) {
                        System.out.println(Double.valueOf(list));
                        price = price + Double.valueOf(list);
                    }
                }

        }
        System.out.println("Total Price: "+price);

    }
}
