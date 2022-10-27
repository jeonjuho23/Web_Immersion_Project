package com.example.springdemo.ex;


public class Calculation {
    private int firstNum;
    private int secondNum;

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public void addition(){
        System.out.println("addition()");
        int firstNum = this.getFirstNum();
        int secondNum = this.getSecondNum();
        int result = firstNum + secondNum;
        System.out.println(firstNum + "+" + secondNum + "=" + result );
    }

    public void subtraction(){
        System.out.println("addition()");
        int firstNum = this.getFirstNum();
        int secondNum = this.getSecondNum();
        int result = firstNum - secondNum;
        System.out.println(firstNum + "-" + secondNum + "=" + result );
    }

    public void multiplication(){
        System.out.println("addition()");
        int firstNum = this.getFirstNum();
        int secondNum = this.getSecondNum();
        int result = firstNum * secondNum;
        System.out.println(firstNum + "*" + secondNum + "=" + result );
    }

    public void division(){
        System.out.println("addition()");
        int firstNum = this.getFirstNum();
        int secondNum = this.getSecondNum();
        int result = firstNum / secondNum;
        System.out.println(firstNum + "/" + secondNum + "=" + result );
    }
}
