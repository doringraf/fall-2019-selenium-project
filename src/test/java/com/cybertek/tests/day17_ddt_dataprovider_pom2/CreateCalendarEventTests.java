package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;

public class CreateCalendarEventTests extends VytrackTestBase {

    @Test
    public void allDayEventRadioTest(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));

        driver.get("https://qa3.vytrack.com/calendar/event/create");

       assertFalse(createCalendarEventsPage.allDayEventCheckbox.isSelected());
    }

    @Test
    public void repeatCheckBoxTest(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));

        driver.get("https://qa3.vytrack.com/calendar/event/create");

        assertFalse(createCalendarEventsPage.repeatCheckbox.isSelected());

    }

}
