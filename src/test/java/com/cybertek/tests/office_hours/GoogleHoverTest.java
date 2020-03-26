package com.cybertek.tests.office_hours;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHoverTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
    }
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void test(){
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.id("gbqfbb"));

        actions.pause(1000).
                moveToElement(button).pause(1000).
                build().perform();

        String notUnExpected = "I'm Feeling lucky";

        String actual = button.getAttribute("value");
        System.out.println("Actual: "+actual);
        Assert.assertNotEquals(actual,notUnExpected);
    }
}
