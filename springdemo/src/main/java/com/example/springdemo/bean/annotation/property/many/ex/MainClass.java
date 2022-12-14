package com.example.springdemo.bean.annotation.property.many.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

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

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();
        ctx.getEnvironment().setActiveProfiles(config);
        ctx.load("applicationCTX_dev.xml","applicationCTX_run.xml");

        ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
        System.out.println(info.getIpNum());
        System.out.println(info.getPortNum());

        ctx.close();
    }
}
