package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class MenuOptionsTests extends VytrackTestBase {

    @Test
    public void test(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        dashboardPage.changeMenu("Acqtivities", "Calendar Events");
        wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));
        assertEquals(driver.getTitle(), "Calendar Events - Activities");
    }


    //DDT test
    @Test(dataProvider = "test-data")
    public void ddtTest(String menu1,String menu2, String expectedTitle){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        dashboardPage.changeMenu(menu1,  menu2);

        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @DataProvider(name = "test-data")
    public Object[][] getData(){
        return new Object[][]{
                {"Fleet", "Vehicles", "Car"},
                {"Fleet", "Vehicle Costs", "Vehicle Costs"},
                {"Customers", "Contacts", "Contacts - Customers"},
                {"Activities", "Calendar Events", "Calendar Events - Activities"},
                {"System", "System Calendars", "System Calendars - System"}
        };
}
    @Test
    public void testAllOptionsDriver(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.menu1Options.get(0)));
        
        List<String> expected = Arrays.asList("Fleet", "Customers", "Activities", "System");
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menu1Options);
        assertEquals(actualList, expected);
    }

    }