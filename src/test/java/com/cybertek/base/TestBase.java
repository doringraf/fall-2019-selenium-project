package com.cybertek.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    protected WebDriver driver;

    protected ExtentReports report;  // we create report and we can attach screenshot with it. We use some methods
    protected ExtentHtmlReporter htmlReport;
    protected ExtentTest logger; // logger

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
       // Thread.sleep(2000);
        Driver.closeDriver();
    }
}
