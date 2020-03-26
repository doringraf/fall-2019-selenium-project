package com.cybertek.tests.day10_webelement;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest {
WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void test1(){

        WebElement blue = driver.findElement(By.id("blue"));
// isSelected --> returns true if element is selected
       // System.out.println(blue.isSelected());
// verify is the radio button is selected
        Assert.assertTrue(blue.isSelected());

        WebElement red = driver.findElement(By.id("red"));
        // print red is not selected
        System.out.println(red.isSelected());

        // verifies if the statement is false. If it's false, it passes
        Assert.assertFalse(red.isSelected());

    }

    @Test
    public void test2(){
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));

        red.click();
        Assert.assertFalse(blue.isSelected());

        Assert.assertTrue(red.isSelected());


    }

}
