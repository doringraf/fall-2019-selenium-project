package com.cybertek.tests.office_hours;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExtentReportPractice extends TestBase {

    @BeforeMethod
    public void setUp(){
        report = new ExtentReports(); // this is the actual report .

        String path = System.getProperty("user.dir")+"/test-output-officehour/report.html"; // path where to save

        htmlReport = new ExtentHtmlReporter(path); // generating HTML report so we can open it in Browser

        // setting general system information that will be visible in the report
        report.setSystemInfo("browser", ConfigurationReader.getProperty("browser"));

        report.attachReporter(htmlReport);
    }

    @Test
    public void test1(){
        logger = report.createTest("Login to a website");

        logger.info("Navigating to URL");
        driver.get(ConfigurationReader.getProperty("vytrack_url"));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement user = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submit = driver.findElement(By.id("_submit"));


        logger.info("Enter username");
        user.sendKeys(ConfigurationReader.getProperty("driver_username"));

        logger.info("Enter password");
        password.sendKeys(ConfigurationReader.getProperty("driver_password"));

        logger.info("Click submit button");
        submit.click();
        Assert.assertEquals(driver.getTitle(),"abc");
        logger.pass("PASS: login successful");
    }

    @AfterMethod
    public void flushReport(){
        report.flush();
    }

    /*
        suite - set of test
        regression suite - all tests that cover all functionalities
            client A regression suite
            client B regression suite
        smoke suite - few main test
     */
}
