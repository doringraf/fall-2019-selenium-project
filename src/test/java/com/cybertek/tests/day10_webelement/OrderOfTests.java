package com.cybertek.tests.day10_webelement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOfTests {

    String title;

    @Test(priority = 0)
    public void login(){
        System.out.println("opening the browser");
        System.out.println("capture title");
        title="cbt";
    }

    @Test(priority = 1, dependsOnMethods = "login")
    public void assertTitle(){
        System.out.println("verify the title");
        Assert.assertEquals(title,"cbt");
    }

    @Test(priority = 44)
    public void verifyOtherThings(){
        System.out.println("verify smth else");
    }
}
