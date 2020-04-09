package com.cybertek.tests.office_hours;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TablePractice extends TestBase {

    @BeforeMethod
    public void setUpTests() {
        driver.get("https://www.mockaroo.com/");
        driver.findElement(By.id("num_rows")).clear();
        driver.findElement(By.id("num_rows")).sendKeys("10");
        driver.findElement(By.id("preview")).click();
    }

    @Test
    public void testHeaderCount(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");

        WebElement table = driver.findElement(By.xpath("//table"));
        System.out.println(table.getText());

        List<WebElement> headers = driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(),6);
    }

    @Test
    public void verifyGender(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");

        List<WebElement> genders = driver.findElements(By.xpath("//table[@style]/tbody/tr/td[5]"));
        List<String> gendersText = BrowserUtils.getElementsText(genders);

        for (String each : gendersText) {
            Assert.assertTrue(each.equals("Male") || each.equals("Female"));
        }
    }

    @Test
    public void getJohn (){
        driver.get("http://practice.cybertekschool.com/tables");

        String firstName = "Jason";
        String lastName = "Doe";

        String xpathFullName = "//table[@id='table1']//td[1][.='"+lastName+"']/../td[2][.='"+firstName+"']/../td[4]";

        WebElement amount = driver.findElement(By.xpath(xpathFullName));
        System.out.println(amount.getText());

    }

}
