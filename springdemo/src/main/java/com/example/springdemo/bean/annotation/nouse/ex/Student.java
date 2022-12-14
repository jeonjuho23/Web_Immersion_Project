package com.example.springdemo.bean.annotation.nouse.ex;

import java.util.List;

public class Student {
    private String name;
    private int age;
    private List hobbys;
    private int height;
    private int weight;

    public Student(String name, int age, List hobbys){
        this.name = name;
        this.age = age;
        this.hobbys = hobbys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getHobbys() {
        return hobbys;
    }

    public void setHobbys(List hobbys) {
        this.hobbys = hobbys;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Student(){
        // default
    }



}
