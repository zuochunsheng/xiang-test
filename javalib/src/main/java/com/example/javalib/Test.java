package com.example.javalib;

public class Test {


    public static void main(String[] args) {

        System.err.println("he" + "llo" == "hello");  // true

        System.err.println("he" + new String("llo") == "hello");//false
        System.err.println(("he" + new String("llo")).equals("hello") );//true

    }

}
