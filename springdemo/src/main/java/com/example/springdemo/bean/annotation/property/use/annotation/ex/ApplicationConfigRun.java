package com.example.springdemo.bean.annotation.property.use.annotation.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigRun {

    @Bean
    public ServerInfo serverInfo(){
        ServerInfo serverInfo = new ServerInfo("localhost", "5678");
        return serverInfo;
    }

}
