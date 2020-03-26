package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    @AfterMethod
    public void afterTest(){
       // driver.quit();
    }

    @Test
    public void verifyIfDefault(){

        List<WebElement> allRadios = driver.findElements(By.name("sport"));

        for (WebElement allRadio : allRadios) {
            Assert.assertFalse(allRadio.isSelected());
            System.out.println(allRadio.isSelected());
        }

        WebElement hokeyRadio = driver.findElement(By.id("hockey"));
        hokeyRadio.click();
        Assert.assertTrue(hokeyRadio.isSelected());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < allRadios.size(); j++) {
                if (allRadios.get(j).getAttribute("id").equals("hockey")){
                    continue;
                }
                Assert.assertFalse(allRadios.get(j).isSelected());
            }
        }
    }

}
