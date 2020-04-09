package com.cybertek.homework;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PostOlympics_testCase2 extends TestBase {

    @BeforeMethod
    public void start(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }

    @AfterMethod
    public void finish() throws InterruptedException {
        Driver.closeDriver();
    }

    @Test
    public void leastGold(){
        Assert.assertEquals(smallestGold()," Australia (AUS)");
    }

    @Test
    public void silverCountriesTest(){
        Assert.assertEquals(silverCountries()," South Korea (KOR)");
    }

    @Test
    public void bronzeCountriesTest(){
        Assert.assertEquals(bronzeCountries()," Italy (ITA)");
    }


    public String smallestGold() {
        List<WebElement> nrGoldElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/following-sibling::td[1]"));
        nrGoldElements.remove(nrGoldElements.size()-1);
        List<Integer> nrGold = BrowserUtils.getElementsINTEGER(nrGoldElements);

        List<WebElement> countryElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
        countryElements.remove(countryElements.size()-1);
        List<String> countries = BrowserUtils.getElementsText(countryElements);
        int temp = nrGold.get(0);
        int index = 0;
        for (int i = 0; i < nrGold.size()-1; i++) {
            if(temp>=nrGold.get(i+1)){
                temp = nrGold.get(i+1);
                index = i+1;
            }
        }
        return countries.get(index);
    }

    public String silverCountries(){
        List<WebElement> silverElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/following-sibling::td[2]"));
        silverElements.remove(silverElements.size()-1);
        List<Integer> silverNums = BrowserUtils.getElementsINTEGER(silverElements);

        List<WebElement> countryElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
        countryElements.remove(countryElements.size()-1);
        List<String> countries = BrowserUtils.getElementsText(countryElements);

        int temp = silverNums.get(0);
        int index = 0;
        for (int i = 0; i < silverNums.size()-1; i++) {
            if(temp>=silverNums.get(i+1)){
                temp = silverNums.get(i+1);
                index = i+1;
            }
        }
        return countries.get(index);
    }

    public String bronzeCountries(){
        List<WebElement> bronzeElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/following-sibling::td[3]"));
        bronzeElements.remove(bronzeElements.size()-1);
        List<Integer> bronzeNumber = BrowserUtils.getElementsINTEGER(bronzeElements);

        List<WebElement> countryElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
        countryElements.remove(countryElements.size()-1);
        List<String> countries = BrowserUtils.getElementsText(countryElements);

        int temp = bronzeNumber.get(0);
        int index = 0;
        for (int i = 0; i < bronzeNumber.size()-1; i++) {
            if(temp>=bronzeNumber.get(i+1)){
                temp = bronzeNumber.get(i+1);
                index = i+1;
            }
        }
        return countries.get(index);
    }
}
