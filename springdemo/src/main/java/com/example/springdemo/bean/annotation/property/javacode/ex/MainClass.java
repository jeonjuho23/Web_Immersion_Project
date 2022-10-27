package com.example.springdemo.bean.annotation.property.javacode.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        AdminConnection adminConnection =
                ctx.getBean("adminConnection", AdminConnection.class);

        System.out.println("adminId: "+ adminConnection.getAdminId());
        System.out.println("adminPw: "+ adminConnection.getAdminPw());
        System.out.println("sub_adminId: "+ adminConnection.getSub_adminId());
        System.out.println("sub_adminPw: "+ adminConnection.getSub_adminPw());

    }
}
