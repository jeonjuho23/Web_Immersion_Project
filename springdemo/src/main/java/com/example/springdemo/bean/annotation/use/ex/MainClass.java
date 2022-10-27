package com.example.springdemo.bean.annotation.use.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Student student1 = ctx.getBean("student1", Student.class);
        System.out.println(student1.getName());	//홍길동
        System.out.println(student1.getHobbys());	// 수영, 요리

        StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
        Student student2 = studentInfo.getStudent();	//student1  == student2
        System.out.println(student2.getName());	//홍길동
        System.out.println(student2.getHobbys());	// 수영, 요리

        if(student1.equals(student2)) {
            System.out.println("student1 == student2");
        }

        Student student3 = ctx.getBean("student3", Student.class);
        System.out.println(student3.getName());

        if(student1.equals(student3)) {
            System.out.println("student1 == student3");
        } else {
            System.out.println("student1 != student3");
        }

        Family family = ctx.getBean("family", Family.class);
        System.out.println(family.getPapaName());
        System.out.println(family.getMamiName());
        System.out.println(family.getSisterName());
        System.out.println(family.getBrotherName());

        ctx.close();

    }

}
