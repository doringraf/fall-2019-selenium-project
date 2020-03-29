package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {
    /*
            Go to practice website
            click on file upload link
            upload a file
            click submit
            verify file name is displayed in the next page
     */

    @Test
    public void fileUploadTest() {
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);

        WebElement file_upload = driver.findElement(By.linkText("File Upload"));
        file_upload.click();

        WebElement fileInput = driver.findElement(By.id("file-upload"));

        fileInput.sendKeys("/Users/marufjon/Desktop/my_file.txt");

        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(), "my_file.txt");
    }


}
