package com.example.springdemo.di.constructor.ex;

import java.util.List;

public class Student {
    private String name;
    private String age;
    private String gradeNum;
    private String classNum;
    private List hobby;



    public Student(){
        // default
    }
    public Student(String name, String age, String gradeNum, String classNum){
        this.name = name;
        this.age = age;
        this.gradeNum = gradeNum;
        this.classNum = classNum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(String gradeNum) {
        this.gradeNum = gradeNum;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public List getHobby() {
        return hobby;
    }

    public void setHobby(List hobby) {
        this.hobby = hobby;
    }
}
