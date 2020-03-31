package com.cybertek.tests.day14_test_base_props_driver;

public class Singleton {
    // make constructor private
    private Singleton() {

    }

    protected static String string ;

    public static String getInstance(){
        if (string==null){
            string = "chrome";
        }
        return string;
    }
}
