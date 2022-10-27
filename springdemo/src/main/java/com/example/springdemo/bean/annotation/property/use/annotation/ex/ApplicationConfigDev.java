package com.example.springdemo.bean.annotation.property.use.annotation.ex;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfigDev {

    @Bean
    public ServerInfo serverInfo(){
        ServerInfo serverInfo = new ServerInfo("localhost", "1234");
        return serverInfo;
    }


}
