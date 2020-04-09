package com.cybertek.tests.office_hours;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExamples {

    @Test
    public void test(){


        Assert.assertEquals(11,1,"First test failed");
        Assert.assertEquals(1,1,"second test failed");
        Assert.assertEquals(2,22,"third test failed");

    }
    @Test
    public void test2(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(11,1,"First test failed");
        softAssert.assertEquals(1,1,"second test failed");
        softAssert.assertEquals(2,22,"third test failed");

        softAssert.assertAll();
    }

    @Test
    public void test3(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(false,"First assertion");

        Assert.assertTrue(false,"Second assertion");
        Assert.assertTrue(true,"Third assertion");

        softAssert.assertTrue(true,"Fourth assertion");

        softAssert.assertAll();

        Assert.assertTrue(true,"Fifth assertion");
    }
}
