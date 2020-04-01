package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
            takes a list of web elements
            returns a list of string
     */

    public static List<String> getElementsText(List<WebElement> listEl){
        // give a webelement list and return string elements
        List<String> listStr = new ArrayList<>();
        for (WebElement element : listEl) {
            listStr.add(element.getText());
        }
        return listStr;
    }

    // WebElement to Integer
    public static List<Integer> getElementsINTEGER(List<WebElement> listEl){
        // give a webelement list and return string elements
        List<Integer> listStr = new ArrayList<>();
        for (WebElement element : listEl) {
            listStr.add(Integer.parseInt(element.getText()));
        }
        return listStr;
    }



    // write a utility that takes a String url,
    // changes to tab with given url,
    // if such title is not found, go back to original window
    public static void changeTab (String title, WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)){
                break;
            }
        }
    }


}
