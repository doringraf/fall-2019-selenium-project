package com.cybertek.tests.day9_testing_intro;

import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\t After Class");
    }

    @BeforeMethod  // it is a method that executes once for every method in that class that has annotation @Test
    public void beforeMethod(){
        System.out.println("\t ^^^^^ Before Method ^^^^^^^");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("\t vvvv AFTER METHOD vvvv");
    }

    @Test
    public void test1 () {
        System.out.println("This is test one");
    }

    @Ignore
    @Test
    public void test2 () {
        System.out.println("This is test two");
    }

    @Test
    public void test3 () {
        System.out.println("This is test three");
    }
}
