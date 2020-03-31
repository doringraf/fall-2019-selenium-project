package com.cybertek.tests.day12_pops_tabs_alerts;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlertsExamples {
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
    public void htmlPopup() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
       WebElement button = driver.findElement(By.xpath("//span[.='Destroy the World']")); // "." -> means text
         button.click();
        Thread.sleep(3000);

         WebElement nooo = driver.findElement(By.xpath("//span[.='No']"));
         nooo.click();
        Thread.sleep(3000);
    }

    @Test
    public void jsAlertsAccept() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button1 = driver.findElement(By.xpath("//button[1]"));
        button1.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);

    }

    @Test
    public void jsAlertCancel() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button1 = driver.findElement(By.xpath("//button[2]"));
        button1.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
    }

    @Test
    public void jsAlertsSendkeys() {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        WebElement button3 = driver.findElement(By.xpath("//button[3]"));
//        button3.click();

        Alert alert = null;
        try {
            alert = driver.switchTo().alert();
            alert.sendKeys("Admiral Kunkka");
            alert.accept();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void multiplePopups() throws InterruptedException {
        driver.get("https://www.tutorialsteacher.com/codeeditor?cid=js-1");

        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }


}
