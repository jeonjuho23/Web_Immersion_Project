package com.example.springdemo.aop.annotation.nouse.ex;

public class Worker {
    private String name;
    private int age;
    private String job;

    public Worker() {}
    public Worker(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public void getWorkerInfo() {
        System.out.println("Worker name is " + getName());
        System.out.println("Worker age is " + getAge());
        System.out.println("Worker job is " + getJob());
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
