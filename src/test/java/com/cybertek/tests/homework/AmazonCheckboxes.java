package com.cybertek.tests.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonCheckboxes {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterTest() {
     //   driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html");

        int countFridays =0;

        String title = driver.getTitle();

        System.out.println("title = " + title);


    }
}
