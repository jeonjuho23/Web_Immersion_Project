package com.example.springdemo.bean.annotation.nouse.ex;

public class StudentInfo {
    private Student student;

    public StudentInfo(Student student) {
        this.student = student;}

    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return student;
    }
}
