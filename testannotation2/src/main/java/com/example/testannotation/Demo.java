package com.example.testannotation;

public class Demo {

    @PersonAnnotation(name="jack",address = "beijing")
    public void demo1(){
        System.out.println("I am demo1 method");
    }

    @PersonAnnotation(name="tom",qq = "2769703983",address = "shanghai")
    public void demo2(){
        System.out.println("I am demo2 method");
    }
}
