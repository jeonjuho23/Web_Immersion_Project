package com.example.springdemo.di.setter.ex;

public class Calculator {

    public void addition(int f, int s){
        System.out.println("addition()");
        int result = f+s;
        System.out.println(f + "+" + s + "=" + result );
    }

    public void subtraction(int f, int s){
        System.out.println("addition()");
        int result = f-s;
        System.out.println(f + "-" + s + "=" + result );
    }

    public void multiplication(int f, int s){
        System.out.println("addition()");
        int result = f*s;
        System.out.println(f + "*" + s + "=" + result );
    }

    public void division(int f, int s){
        System.out.println("addition()");
        int result = f/s;
        System.out.println(f + "/" + s + "=" + result );
    }


}
