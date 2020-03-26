package com.cybertek.tests.day12_pops_tabs_alerts;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeExample {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterTest() {
       // driver.quit();
    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/tinymce");

        // switch it to iframe
        // TODO switch by id/name
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great. thanks");

        // get out from the (box) iframe
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h3")));

        // TODO switch by webelement
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);

        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great.thanks one time");

        // get out again
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("h3")));

        // TODO switch by index
        driver.switchTo().frame(0);
        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great.thanks last time");




    }
}
