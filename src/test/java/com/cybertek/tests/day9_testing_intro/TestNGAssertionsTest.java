package com.cybertek.tests.day9_testing_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsTest {

    @Test
    public void test1(){
        String expected = "one";
        String actual = "one";

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(1,1);
        Assert.assertEquals(true,true);

        System.out.println("Test 1 complete");
    }

    @Test
    public void test2(){
        String expected = "one";
        String actual = "two";

        System.out.println("Starting to compare");

    Assert.assertEquals(expected, actual);

        System.out.println("Test 2 complete");
    }

    @Test
    public void test3(){
        String expected = "one";
        String actual = "two";

        Assert.assertNotEquals(expected,actual);
        Assert.assertNotEquals(1,2);
    }

    @Test
    public void test4(){
        String expected = "one";
        String actual = "one";

        Assert.assertTrue(expected.equals(actual));

        int e = 100;
        int a = 200;
        Assert.assertTrue(a>e);
     }

     @Test
    public void test5() {
        // verify that url is equal to https://google.com

         String expected = "https://google.com/";
         String actual = "https://google.com/";

         Assert.assertEquals(expected,actual);

         //verify that title starts with java
         String expected1 = "java";
         String actual1 = "java - Google Search";

         Assert.assertTrue(actual.contains(expected));
     }


}
