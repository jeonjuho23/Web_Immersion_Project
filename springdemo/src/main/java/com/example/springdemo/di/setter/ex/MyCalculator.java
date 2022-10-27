package com.example.springdemo.di.setter.ex;

public class MyCalculator {
    Calculator calculator;
    private int firstNum;
    private int secondNum;

    public MyCalculator(){
        // default
    }

    public void add(){
        calculator.addition(firstNum,secondNum);
    }
    public void sub(){
        calculator.subtraction(firstNum,secondNum);
    }
    public void mul(){
        calculator.multiplication(firstNum,secondNum);
    }
    public void div(){
        calculator.division(firstNum,secondNum);
    }

    // setter 를 통해서 객체를 주입받음
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }
}
