package com.example.springdemo.bean.annotation.property.ex;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = ctx.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        try{
            propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));

            System.out.println(environment.getProperty("admin.id"));
            System.out.println(environment.getProperty("admin.pw"));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        GenericXmlApplicationContext gCtx=(GenericXmlApplicationContext)ctx;
        gCtx.load("applicationCTX4.xml");
        gCtx.refresh();

        AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
        System.out.println("admin Id" + adminConnection.getAdminId());
        System.out.println("admin pw" + adminConnection.getAdminPw());

        gCtx.close();
        ctx.close();
    }
}
