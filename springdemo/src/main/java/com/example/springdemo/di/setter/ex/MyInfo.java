package com.example.springdemo.di.setter.ex;

import java.util.List;

public class MyInfo {
    private String name;
    private double height;
    private double weight;
    private List hobbys;
    private BMICalculator bmiCalculator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List getHobbys() {
        return hobbys;
    }

    public void setHobbys(List hobbys) {
        this.hobbys = hobbys;
    }

    public BMICalculator getBmiCalculator() {
        return bmiCalculator;
    }

    public void setBmiCalculator(BMICalculator bmiCalculator) {
        this.bmiCalculator = bmiCalculator;
    }

    public void bmiCalculation(){
        bmiCalculator.bmicalculation(this.weight, this.height);
    }

    public void getInfo(){
        System.out.println("이름: "+ this.name);
        System.out.println("키: "+ this.height);
        System.out.println("몸무게: "+ this.weight);
        System.out.println("취미: "+ this.hobbys);
        this.bmiCalculation();
    }
}
