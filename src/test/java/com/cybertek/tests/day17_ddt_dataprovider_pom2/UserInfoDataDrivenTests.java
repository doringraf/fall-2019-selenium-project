package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInfoDataDrivenTests {

    @Test (dataProvider = "users")
    public void test(String username, String password, int numbers){
        System.out.println("Opening application");
        System.out.println("Login as: "+username);
        System.out.println("number as: "+numbers);
        System.out.println("verify info");
    }

    @DataProvider( name= "users")
    public Object[][] getUsers(){
            return new Object[][]
            {
                    {"user1","UserUser123",25},
                    {"user2","UserUser123",25},
                    {"user3","UserUser123",25}
            };
    }


}
