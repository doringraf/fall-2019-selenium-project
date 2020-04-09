package com.cybertek.homework;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OlympicName_testCase4 extends TestBase {
    @BeforeMethod
    public void start() {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }

    @AfterMethod
    public void finish() throws InterruptedException {
        Driver.closeDriver();
    }

    @Test
    public void findNameTest(){
        int [][] rowColumn = rowColumnCountry("JPN");
        System.out.println("rowColumn = " + rowColumn[0][0]+""+rowColumn[0][1]);
    }

    public int[][] rowColumnCountry (String country){
        int arr[][] = new int[1][2];
        arr[0][1] = 2;
        List<WebElement> table = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));

       int rowsTable = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr")).size()-2;

        for (int i = 1; i <= rowsTable; i++) {
            if(driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr["+i+"]/th")).getText().contains(country)){
                arr [0][0] = i;
            }
        }

//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[1]/th[1]
        return arr;
    }
}
