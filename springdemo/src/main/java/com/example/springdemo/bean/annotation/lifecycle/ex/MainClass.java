package com.example.springdemo.bean.annotation.lifecycle.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX4.xml");

        Student student = ctx.getBean("student",Student.class);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println("---------------");

        Student student2 = ctx.getBean("student",Student.class);
        student.setName("홍길자");
        student.setAge(15);
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println("---------------");

        if(student.equals(student2)){
            System.out.println("student == student2");
        }else{
            System.out.println("student != student2");
        }

        ctx.close();

    }
}
