package com.cybertek.tests.office_hours;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DifferentBrowsers extends TestBase {

        @Test
    public void test(){
            System.out.println("OPTION 1");
            System.out.println(ConfigurationReader.getProperty("browser"));
            System.out.println("OPTION 2");
            System.out.println(driver);
            if (driver.toString().contains("FirefoxDriver")){
                System.out.println("This si firefox");
            } else if (driver.toString().contains("ChromeDriver")){
                System.out.println("This is chrome");
            }

            System.out.println("OPTION 3");

            if (driver instanceof FirefoxDriver) {
                System.out.println("This is firefoooox");
            } else if (driver instanceof ChromeDriver) {
                System.out.println("This is chrooome");
            }
        }
}
