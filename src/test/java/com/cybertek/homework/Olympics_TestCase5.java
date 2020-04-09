package com.cybertek.homework;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Olympics_TestCase5 extends TestBase {
    @BeforeMethod
    public void start() {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }

    @AfterMethod
    public void finish() throws InterruptedException {
        Driver.closeDriver();
        Thread.sleep(1000);
    }

    @Test
    public void sumBronze18(){
        List<String> countries = new ArrayList<>();

        List<WebElement> bronzesElement = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4]"));

        List<Integer> bronzes = BrowserUtils.getElementsINTEGER(bronzesElement);
        bronzes.remove(bronzes.size()-1);
        bronzes.remove(bronzes.size()-1);

        for (int i = 0; i < bronzes.size(); i++) {
            for (int j = i+1; j < bronzes.size(); j++) {
                int a = bronzes.get(i);
                int b = bronzes.get(j);
                if (a+b==18){
                    countries.add(driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr["+(i+1)+"]/th")).getText());
                    countries.add(driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr["+(j+1)+"]/th")).getText());
                }
            }
        }
        System.out.println("bronzes = " + bronzes);
        System.out.println("countries = " + countries);
    }

}
