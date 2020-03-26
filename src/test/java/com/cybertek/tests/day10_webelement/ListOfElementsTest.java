package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    /*
    go to page radio buttons
    verify that none of the sports radio buttons are selected
     */

    @Test
    public void listOfRadioButtons(){
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // driver.findElementS --> returns a LIST of element
        List<WebElement> sports = driver.findElements(By.name("sport"));

        System.out.println(sports.size());

        for (WebElement radioButton : sports) {
            Assert.assertFalse(radioButton.isSelected());
        }

    }


    @Test
    public void getAllLinksTest(){
        driver.get("http://practice.cybertekschool.com/");

        // get all the links in the page

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }


        /*
     go to amazon
     search for paper towels
     print the number of results
     print the first result
     print the second result
     print the last result
      */
        @Test
    public void amazonTest(){
        driver.get("https://amazon.com");

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));

        input.sendKeys("paper towels"+ Keys.ENTER);
//span.a-size-base-plus.a-color-base.a-text-normal

          List<WebElement> allResults =  driver.findElements(By.cssSelector("span.a-size-base-plus"));
            System.out.println("There are : "+allResults.size());

            System.out.println("First result:" + allResults.get(0).getText());
            System.out.println("Mid result:" + allResults.get(allResults.size()/2).getText());
            System.out.println("Last result:" + allResults.get(allResults.size()-1).getText());

        }

}
