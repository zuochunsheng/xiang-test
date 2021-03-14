package com.example.javalib;

public class TryDemo {

    static int test() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            x++;
            System.out.println("finally模块被执行: " + x);
        }
    }
//    分析：
//    在try语句中，在执行return语句时，要返回的结果已经准备好了，就在此时，程序转到finally执行了。
//    在转去之前，try中先把要返回的结果存放到不同于x的局部变量中去，执行完finally之后，在从中取出返回结果，
//    因此，即使finally中对变量x进行了改变，但是不会影响返回结果。
//    它应该使用栈保存返回值。

    public static String show() {
        //       try {
//            return 1;
//        }finally{
//            System.out.println("finally模块被执行");
//            //return 0;
//        }

//        try {
//            int a = 8/0;
//            return 1;
//        }catch (Exception e) {
//            return 2;
//        }finally{
//            System.out.println("finally模块被执行");
//            //return 0;
//        }

        // int result = 1;
//        TestClass2 t = new TestClass2();
//        try {
//            TestClass2 aDouble = t.Double();
//            return aDouble;
//        } finally {
//            t.value++;
//            System.out.println("finally模块被执行 " + t.value);
//
//        }

        //String result = "a"; 常量
        String result = new String("a");
        try {
            result +="b";
            return result;
        } finally {
            result +="c";
            System.out.println("finally模块被执行 " + result);

        }

    }

    public static void main(String args[]) {
        //System.out.println(test());

        //System.out.println(show().value);
        System.out.println(show());

    }


    public static class TestClass2 {
        public int value = 1;

        public TestClass2 Double() {
            value *= 2;
            return this;
        }
    }

}


//任何执行try 或者catch中的return语句之前，都会先执行finally语句，如果finally存在的话。
//如果finally中有return语句，那么程序就return了，所以finally中的return是一定会被return的，
