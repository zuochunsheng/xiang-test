package com.example.javalib;

//构造方法可以重载overload，必须重写 override
//如果父类中只有 一个有参数的构造方法，那么子类必须重写父类的构造方法
// 父类型引用 指向子类对象时，子类重写父类方法和属性，那么 访问的属性是父类的属性 ，访问的方法是子类的方法
public class Json extends People {

    protected String name = "json";
//    public Json(String name){
//        super(name);
//    }

    @Override
    protected void say() {
        System.out.println("json");
    }



}

//接口的特点：
//1 接口的声明都是 public static final 修饰
//2 接口可以多继承
//3 接口中的方法都是抽象方法
//4 接口是没有构造函数的
//5 接口不能直接实例化