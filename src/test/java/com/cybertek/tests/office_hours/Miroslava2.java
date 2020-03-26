package com.cybertek.tests.office_hours;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Miroslava2 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");

        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));

        /*
                we have stored all frames webelements inside the list
                1. Loop through list
                2. switch to each frame
                    a. get text from body
                    b. switch to parent
         */


        for (WebElement eachElement : frameList) {
            driver.switchTo().frame(eachElement);
            String bodyTest = driver.findElement(By.tagName("body")).getText();
            System.out.println("bodyTest = " + bodyTest);
            driver.switchTo().parentFrame();
        }

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bodyTest = driver.findElement(By.tagName("body")).getText();
        System.out.println("bodyTest = " + bodyTest);



    }

}
