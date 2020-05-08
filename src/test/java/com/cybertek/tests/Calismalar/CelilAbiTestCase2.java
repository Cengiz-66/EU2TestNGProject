package com.cybertek.tests.Calismalar;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CelilAbiTestCase2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
      driver= WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //1. go to: "https://www.cheapoair.com/flights/book-now-pay-later-flights"
        driver.get("https://www.cheapoair.com/flights/book-now-pay-later-flights");
        //2. close the cookies info bar by clicking I Accept button
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class=\"gdpr-close\"]"))));
        driver.findElement(By.xpath("//a[@class=\"gdpr-close\"]")).click();
        //3. click the one way radio button
        WebElement oneWayRadioButton = driver.findElement(By.id("owFlight"));
        wait.until(ExpectedConditions.elementToBeClickable(oneWayRadioButton));
        oneWayRadioButton.click();
        //4. verify -> Assert that round trip is not selected
        WebElement roundTripRadioButton = driver.findElement(By.id("rtFlight1"));
        Assert.assertFalse(oneWayRadioButton.isSelected(),"verify that round trip is NOT selected");
        Thread.sleep(3000);
        //5. clear the default content from "FROM" inputbox
        WebElement fromBox = driver.findElement(By.id("ember532"));
        wait.until(ExpectedConditions.visibilityOf(fromBox));
        fromBox.clear();
        //6. send "fk" to FROM input box
        fromBox.sendKeys("fk");
       // 7. print all suggested airports from the list

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"ember531\"]/div[2]/div/section/div/ul/li"));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        //8. select the kennedy airport from the list
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if(element.getText().contains("Kennedy")) {
                element.click();
                break;
            }
        }
        // 9.send "be" to input box and hit TAB key to select the first option
        WebElement inputBox = driver.findElement(By.id("ember547"));
        wait.until(ExpectedConditions.visibilityOf(inputBox));
        inputBox.sendKeys("pa");
        List<WebElement> elementsto = driver.findElements(By.xpath("//*[@id=\"ember546\"]/div[2]/div/section/div/ul/li"));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsto));
        for (WebElement element : elementsto) {
            System.out.println(element.getText());
        }

        for (WebElement element : elementsto) {
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.getText().contains("Paris")) {
                element.click();
                break;
            }
        }
        //10.select depart date (PS: to select may 10, click on the opened calendar. data-date attribute for May 10 is 1589061600)
        WebElement date = driver.findElement(By.xpath("//li[@data-date=\"1589061600\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(date));
        date.click();
        //11.select 2 adult
        Select adultBox=new Select(driver.findElement(By.id("ember567")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ember567"))));
        adultBox.selectByVisibleText("2");
       // 12.select 2 child
        Select childBox=new Select(driver.findElement(By.id("ember569")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ember569"))));
        childBox.selectByVisibleText("2");
        //13.check whether child age drop down is visible - Assert ?
        WebElement childAge=driver.findElement(By.id("minor-age-template"));
        Assert.assertTrue(childAge.isDisplayed(),"verify that child age dropdown is displayed");
        //14.select child age as 4 and 1
        Select childAgeBox=new Select(driver.findElement(By.xpath("(//div[@id=\"minor-age-template\"])[1]//select")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[@id=\"minor-age-template\"])[1]//select"))));
        childAgeBox.selectByVisibleText("4");
        childAgeBox=new Select(driver.findElement(By.xpath("(//div[@id=\"minor-age-template\"])[2]//select")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[@id=\"minor-age-template\"])[1]//select"))));
        childAgeBox.selectByVisibleText("Under 2 (seat)");
        //15.select FIRST CLASS from the class drop down by using drop down index
        Select firstClassSelection=new Select(driver.findElement(By.id("ember572")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ember572"))));
        firstClassSelection.selectByIndex(3);
        //16.click on "Search Now"
        driver.findElement(By.xpath("//*[@id=\"ember516\"]/section/form/input")).click();
        Thread.sleep(20000);
       // 17.print the first carrier and price on the list
        List<WebElement> airlinesList = driver.findElements(By.cssSelector(".col-xs-2.trip__airline"));
        wait.until(ExpectedConditions.visibilityOfAllElements(airlinesList));
        List<WebElement> priceList = driver.findElements(By.cssSelector("button>strong.fare__amount.is--total>span.currency[defaultvalue]"));
        System.out.println(airlinesList.get(0).getText()+"-"+priceList.get(0).getAttribute("innerHTML"));

    }
}
