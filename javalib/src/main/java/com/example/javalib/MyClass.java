package com.example.javalib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.zip.DataFormatException;

public class MyClass {


    public static void main1(String[] args) {
        char ch = '9';

        //char转int
        if (Character.isDigit(ch)) {// 判断是否是数字
            // int num = Integer.parseInt(ch);//error
            int num1 = Integer.parseInt(String.valueOf(ch));//方式一
            System.out.println("num1:" + num1);


            int num2 = (int) ch - (int) ('0');//方式二
            System.out.println("num2:" + num2);//9

            double dou = (double) ch - (double) ('0');
            System.out.println("double:" + dou);//9.0
        }


//        String str =  String.valueOf(ch);
//        System.out.println("str:"+str);


        //int转char
        int number = 9;
        char cNumber = (char) (number + '0');
        System.out.println("Number " + number + " to char is:" + cNumber);


    }


    //尽量在布尔表达式中 不使用浮点型数据
    //因为 计算机在浮点型数据类型运算的时候，会有误差。

    // BigDecimal


    public static void main(String[] args) {

//        int[] ints = {1, 2, 3};
//
//        changeInts(ints);
//
//        for (int anInt : ints) {
//            System.out.println("anInt:" + anInt);
//        }

        pp();
    }

    private static void changeInts(int[] ints) {

        ints[1] = 10;

    }

    private static void pp() {
        //        Math.abs()  绝对值
//        Math.pow()  幂运算
//        Math.sqrt()  平方根
//        Math.round()  四舍五入
//
//        Math.random()  0-1的随机数 包括0，不包括1


//        String str = "111";
//        char c = str.charAt();

        //Peoper p = new Peoper("haohao");
        //Json p = new Json("haohao");
        People p = new Json();
        System.out.println("name:" + p.name);//parent,
        p.say();//json

        //运行时异常
        //ClassNotFoundException
//        FileNotFoundException
        //IOException
        //DataFormatException
//        NoSuchMethodException

        //编译时异常
//        ClassCastException
//        EmptyStackException
//        IllegalArgumentException
//        IndexOutOfBoundsException
//        NullPointerException
//        ArithmeticException

//        71  Try块必须存在 ，catch 和 finally可以不存在，单不能同时不存在

    }


}