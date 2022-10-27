package com.example.springdemo.bean.annotation.bean.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    @Bean
    public Student student1(){
        List hobbys = new ArrayList();
        hobbys.add("수영");
        hobbys.add("요리");

        Student student = new Student("홍길동", 20, hobbys);
        student.setHeight(180);
        student.setWeight(80);

        return student;
    }

    @Bean
    public Student student2() {
        List hobbys = new ArrayList();
        hobbys.add("독서");
        hobbys.add("음악감상");

        Student student = new Student("홍길순", 18, hobbys);
        student.setHeight(160);
        student.setWeight(50);

        return student;
    }
}
