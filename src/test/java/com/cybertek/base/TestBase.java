package com.cybertek.base;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
   protected WebDriver driver;

    @BeforeMethod
    public void setUpTest(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.quit();
    }
}
