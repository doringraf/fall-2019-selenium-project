package com.cybertek.tests.office_hours;

import java.util.*;

public class practicingCodyingBat {
//    wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
//    wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
//    wordCount(["c", "c", "c", "c"]) → {"c": 4}
    //wordCount(["this", "and", "this", ""]) → {"": 1, "and": 1, "this": 2}
    public static void main(String[] args) {
        String[] strings = {"this", "and", "this", "", "a","a","a"};

        Map<String, Integer> map = new HashMap<String, Integer>();

        String uniqueOnes = "";

        for (String string : strings) {
            if(!uniqueOnes.contains(string)){
                uniqueOnes+=string;
            }
        }



        System.out.println(map);










        
    }
}
