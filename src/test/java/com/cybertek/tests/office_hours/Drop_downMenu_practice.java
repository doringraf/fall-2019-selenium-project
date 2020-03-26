package com.cybertek.tests.office_hours;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Drop_downMenu_practice {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
    /*
    go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    verify that table has dropdown with values Family, Friends, Coworkers, Businesses, Contacts
    select option Corworkers
    verify that that Coworkers is now selected
    select options Contacts
    verify that contacts is selected
     */
    @Test
    public void test() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
            Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        // getOption --> gives all available options as a list of web elements

        List<WebElement> allOptionsEl = categories.getOptions();

        System.out.println("Number of options "+ allOptionsEl.size());

        List<String> expectedOptions = Arrays.asList("Family", "Friends", "Coworkers", "Businesses", "Contacts");

        // given a list web elements, extract the text of the elements into new list of strings
        List<String> allOptionsStr = BrowserUtils.getElementsText(allOptionsEl);

        Assert.assertEquals(allOptionsStr,expectedOptions);
    }

       /*
    go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    select option Coworkers
    verify that that Coworkers is now selected
    select options Contacts
    verify that contacts is selected
     */
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        //  select option Coworkers
        categories.selectByVisibleText("Coworkers");
//        verify that that Coworkers is now selected
        // getFirstSelectedOption --> returns the currently selected option as Web element
      categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        String actual = categories.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, "Coworkers");


        // select option
        categories.selectByVisibleText("Contacts");
        categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        actual = categories.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,"Contacts");

    }
    /**
     * go to http://practice.cybertekschool.com/dropdown
     * verify taht days table has days sorted in ascending order
     */
    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select days = new Select(driver.findElement(By.id("day")));
        List<WebElement> daysList = days.getOptions();
        System.out.println("There are options: "+daysList.size());

        List<String> stringList = BrowserUtils.getElementsText(daysList);

        List<Integer> ints = new ArrayList<>();
        for (String string : stringList) {
            ints.add(Integer.parseInt(string));
        }

        System.out.println(ints);

        List<Integer> intsCopy = new ArrayList<>(ints);
        Collections.sort(intsCopy);

        Assert.assertEquals(ints, intsCopy);
    }



}












