package com.example.springdemo.bean.annotation.property.use.annotation.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        String config = null;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if (str.equals("dev")) {
            config = "dev";
        } else if (str.equals("run")) {
            config = "run";
        }
        scanner.close();

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles(config);
        ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
        ctx.refresh();

        ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
        System.out.println(info.getIpNum());
        System.out.println(info.getPortNum());

        ctx.close();
    }
}
