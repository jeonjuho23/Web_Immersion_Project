package com.example.springdemo.aop.annotation.use.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX_AOP.xml");
//        ctx.refresh();

        Student student = ctx.getBean("studentkerm ", Student.class);
        student.getStudentInfo();

        Worker worker= ctx.getBean("worker", Worker.class);
        worker.getWorkerInfo();

        ctx.close();
    }
}
