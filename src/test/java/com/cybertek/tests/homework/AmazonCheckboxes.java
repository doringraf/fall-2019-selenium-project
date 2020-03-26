package com.cybertek.tests.homework;

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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AmazonCheckboxes {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterTest() {
    //  driver.quit();
    }

    @Test
    public void days() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html");

        int countFridays =0;
        Thread.sleep(1000);
        Random rand = new Random();
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[starts-with(@id,'gwt-debug-cwCheckBo')]"));
        List<WebElement> allBoxesName = driver.findElements(By.xpath("//input[starts-with(@id,'gwt-debug-cwCheckBo')]/following-sibling::label"));

       do {
           int random = rand.nextInt(allBoxes.size());
           WebElement oneBox = allBoxes.get(random);
           if (!oneBox.isEnabled()){
               continue;
           }
           WebElement oneBoxText = allBoxesName.get(random);
            oneBox.click();
           System.out.println(oneBoxText .getText());
           oneBox.click();
           if(oneBoxText.getText().equals("Friday")){
               countFridays++;
           }
       } while (countFridays!=3);
    }

    @Test
    public void TodayDay() {
        LocalDate localDate = LocalDate.now();

        String year = String.valueOf(localDate.getYear());
        String month = localDate.getMonth().name().toLowerCase();
        String day = String.valueOf(localDate.getDayOfMonth());

        driver.get("http://practice.cybertekschool.com/dropdown");
        String yearElement = new Select(driver.findElement(By.id("year"))).getFirstSelectedOption().getText();
        String monthElement = new Select(driver.findElement(By.id("month"))).getFirstSelectedOption().getText().toLowerCase();
        String dayElement = new Select(driver.findElement(By.id("day"))).getFirstSelectedOption().getText();

        Assert.assertEquals(year,yearElement);
        Assert.assertEquals(month,monthElement);
        Assert.assertEquals(day,dayElement);
    }

    @Test
    public void yearsMonthsdays () {
        Random rand = new Random();
        driver.get("http://practice.cybertekschool.com/dropdown");
        // All year elements
        Select yearElement = new Select(driver.findElement(By.id("year")));
        List<WebElement> allYears = yearElement.getOptions();
        // Random number for selecting a year
        int randomNr = rand.nextInt(allYears.size());

        allYears.get(randomNr).click(); /// click on a random year
        int year = Integer.parseInt(yearElement.getFirstSelectedOption().getText()); // make it int
        // All months elements
        Select monthElement = new Select(driver.findElement(By.id("month")));
        List<WebElement> allMonths = monthElement.getOptions();
        // All days elements
        Select dayElement = new Select(driver.findElement(By.id("day")));
        List<WebElement> allDays = dayElement.getOptions();

        // VERIFYING
        for (int i = 0; i < allMonths.size(); i++) {
            monthElement.selectByIndex(i);
            String month = monthElement.getFirstSelectedOption().getText();
            if(year % 4 == 0 && month.equals("January")) {
                System.out.println("--- LEAP YEAR ---");
                Assert.assertEquals(allDays.size(),29);
            }
        }
    }

    @Test
    public void departments_sort (){
        driver.get(" https://www.amazon.com ");


        String defaultValue = driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText();
        Assert.assertEquals(defaultValue,"All");

        Select allDeparts = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> allDepartments = allDeparts.getOptions();
        List<String> stringDepartments = BrowserUtils.getElementsText(allDepartments);
        List<String> stringDepartmentsCopy = BrowserUtils.getElementsText(allDepartments);

        Collections.sort(stringDepartmentsCopy);

        Assert.assertNotEquals(stringDepartments,stringDepartmentsCopy);


    }




}
