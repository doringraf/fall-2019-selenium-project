package com.cybertek.tests.office_hours;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class ChangeMenuAssertTest extends VytrackTestBase {

    @Test
            public void TestMenuOption() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));

        assertNotEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/");

    }
}
