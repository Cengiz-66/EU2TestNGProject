package com.cybertek.tests.Calismalar;

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

public class CalismaWebTables {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @AfterMethod
    public void closeClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        WebElement printTable = driver.findElement(By.cssSelector("table#table1"));
        System.out.println(printTable.getText());
        Assert.assertTrue(printTable.getText().contains("jsmith@gmail.com"), "verify that 'jsmith@gmail.com' is in list ");
    }

    @Test
    public void getAllHeaders() {
        //how many columns we have ?
        List<WebElement> headList = driver.findElements(By.cssSelector("table#table1 th"));
        System.out.println(headList.size());
        //print each column name one by one
        for (int i = 0; i < headList.size(); i++) {
            System.out.println(headList.get(i).getText());
        }
    }

    @Test
    public void printTableSize() {
        //how many columns we have ?
        List<WebElement> headList = driver.findElements(By.cssSelector("table#table1 th"));
        System.out.println("columns number: " + headList.size());
        //number of rows with header
        List<WebElement> allRows = driver.findElements(By.cssSelector("table#table1 tr"));
        System.out.println("rows number with head: " + allRows.size());
        //number of rows without header(we prefer this)
        List<WebElement> rows = driver.findElements(By.cssSelector("table#table1>tbody>tr"));
        System.out.println("rows number without head: " + rows.size());

    }

    @Test
    public void getRow() {
        //print the second row information
        WebElement secondRow = driver.findElement(By.cssSelector("table#table1>tbody>tr:nth-of-type(2)"));
        System.out.println("secondRow = " + secondRow.getText());
        //get all the rows dynamically
        //1.find the number of rows
        //2.iterate one by one
        List<WebElement> rows = driver.findElements(By.cssSelector("table#table1>tbody>tr"));
        for (int i = 1; i <= rows.size(); i++) {
            WebElement row = driver.findElement(By.cssSelector("table#table1>tbody>tr:nth-of-type(" + i + ")"));
            System.out.println("row" + i + " = " + row.getText());
        }

    }

    @Test
    public void getAllCellInOneRow() {

        List<WebElement> secondRowsCells = driver.findElements(By.cssSelector("table#table1>tbody>tr:nth-of-type(2) td"));
        System.out.print("secondRowsCell ==> ");
        for (WebElement secondRowsCell : secondRowsCells) {
            System.out.print(secondRowsCell.getText() + " | ");
        }
    }

    @Test
    public void getASingleCellByIndex() {

        WebElement singleCell = driver.findElement(By.xpath("//*[@id=\"table1\"]//tbody/tr[1]/td[3]"));
        System.out.println("singleCell = " + singleCell.getText());

    }

    @Test
    public void PrintAllCellsByIndex() {
        List<WebElement> rowList = driver.findElements(By.xpath("//*[@id=\"table1\"]//tbody/tr"));
        int rowNumber = rowList.size();
        List<WebElement> columnList = driver.findElements(By.xpath("//*[@id=\"table1\"]//thead//th"));
        int columnNumber = columnList.size();
        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {

            //iterate through each cell for each row
            for (int j = 1; j <= columnNumber; j++) {

                String cellXpath = "//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[" + j + "]";
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.print(cell.getText() + " | ");

            }
            System.out.println();

        }

    }

    @Test
    public void testMethod() {
        System.out.println(reachTheCell(4, 5).getText());
    }
    //create a method that accepts row and col number, and returns the cell as a webelement
    public WebElement reachTheCell(int row, int col) {

        WebElement cell = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + row + "]/td[" + col + "]"));
        return cell;
    }

    @Test
    public void test66() {
        List<WebElement> rowList = driver.findElements(By.xpath("//*[@id=\"table1\"]//tbody/tr"));

        for (int i = 1; i <=rowList.size() ; i++) {
            System.out.print(reachTheCell(i, 2).getText()+" | ");
            System.out.print(reachTheCell(i, 1).getText()+" | ");
            System.out.print(reachTheCell(i, 4).getText()+" | ");
            System.out.println();
        }

    }



}
