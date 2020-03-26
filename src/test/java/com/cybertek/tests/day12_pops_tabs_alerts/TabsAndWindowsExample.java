package com.cybertek.tests.day12_pops_tabs_alerts;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindowsExample {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterTest() {
        //driver.quit();
    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        // get all the available tabs
        Set<String> windowHandles = driver.getWindowHandles();

        // print all the windows handles
        for (String windowHandle : windowHandles) {
            System.out.println(windowHandle);
        }

        // get the id of current window/tab
        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);
        System.out.println("BEFORE SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle); // this one is actually switching
            if (driver.getTitle().equals("New Window")) {
                break;
            }
        }

        System.out.println("AFTER SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        BrowserUtils.changeTab("New Windows", driver);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html");

        String title = driver.getTitle();

        System.out.println("title = " + title);

    }


    }