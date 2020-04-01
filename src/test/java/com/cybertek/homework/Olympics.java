package com.cybertek.homework;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Olympics extends TestBase {
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
    public void test1(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");

        List<WebElement> rowsNoHead  = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr"));
        rowsNoHead.remove(rowsNoHead.size()-1);
        rowsNoHead.remove(rowsNoHead.size()-1);

        List<WebElement> eachRank = new ArrayList<>();

        for (int i = 1; i <= rowsNoHead.size(); i++) {
            eachRank.add(driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr["+i+"]/td")));
        }

        List<Integer> numsRank = BrowserUtils.getElementsINTEGER(eachRank);  // actual Rank List
        List<Integer> cloneRank = new ArrayList<>(numsRank);
        Collections.sort(cloneRank);

    Assert.assertEquals(numsRank,cloneRank);

    // clicking on NOC
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead/tr/th[2]")).click();

        List<WebElement> countryNamesElements  = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th/a"));
        List<String> countryNames = BrowserUtils.getElementsText(countryNamesElements);

        List<String> countryNamesCLONE = new ArrayList<>(countryNames);
        Collections.sort(countryNamesCLONE);


        Assert.assertEquals(countryNames,countryNamesCLONE);
    ////////////
        List<WebElement> ranksAgain = new ArrayList<>();
        for (int i = 1; i <= countryNames.size(); i++) {
            if (driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr["+i+"]/td[1]")).getText().equals("11–86")){
                continue;
            }
            ranksAgain.add(driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr["+i+"]/td[1]")));
        }
        List<Integer> ranksAgainInts = BrowserUtils.getElementsINTEGER(ranksAgain);

        Assert.assertNotEquals(cloneRank,ranksAgainInts);



    }
}
