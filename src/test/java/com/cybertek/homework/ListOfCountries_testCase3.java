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
import java.util.Comparator;
import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class ListOfCountries_testCase3 extends TestBase {


    @BeforeMethod
    public void start() {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }

    @AfterMethod
    public void finish() throws InterruptedException {
        Driver.closeDriver();
    }

    @Test
    public void silverCountriesTest() {
        System.out.println(silverCountries());
    }


    public List<String> silverCountries() {
        List<WebElement> silverElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th/following-sibling::td[2]"));
        silverElements.remove(silverElements.size() - 1);
        List<Integer> silverNums = BrowserUtils.getElementsINTEGER(silverElements);

        List<WebElement> countryElements = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
        countryElements.remove(countryElements.size() - 1);
        List<String> countries = BrowserUtils.getElementsText(countryElements);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < countries.size(); i++) {
            map.put(countries.get(i),silverNums.get(i));
        }

        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, comparator.reversed());

        List<String > toGoOut = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
            toGoOut.add(stringIntegerEntry.getKey());
        }

        return toGoOut;
    }
}


