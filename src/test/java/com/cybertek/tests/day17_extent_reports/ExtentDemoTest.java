package com.cybertek.tests.day17_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //this class is used for starting and building reports
    ExtentReports report;
    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs,authors,test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {
        //initialize the class
        report=new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath +"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter=new ExtentHtmlReporter(path);


        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("Tester","Caki");

    }

    @Test
    public void test1() {
        //give name the current test
        extentLogger=report.createTest("TC123 Login as Drevier Test");

        //test steps
        //info() -->write test steps
        extentLogger.info("Open chrome");
        extentLogger.info("go to url");
        extentLogger.info("enter driver username and password");
        extentLogger.info("click submit");
        extentLogger.info("Verify logged in");

        //pass()--> marks the test case as passed
        extentLogger.pass("TC123 is passed");


    }

    @AfterMethod
    public void tearDown() {
        //this is when the report is actually created
        report.flush();
    }



}
