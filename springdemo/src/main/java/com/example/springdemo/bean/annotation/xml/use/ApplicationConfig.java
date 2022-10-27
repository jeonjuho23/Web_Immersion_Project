package com.example.springdemo.bean.annotation.xml.use;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ImportResource("classpath:applicationCTX3.xml")
public class ApplicationConfig {

    @Bean
    public Student student1(){
        List hobbys = new ArrayList();
        hobbys.add("수영"); hobbys.add("요리");
        Student student = new Student("홍길동", 20, hobbys);
        student.setHeight(180);   student.setWeight(80);
        return student;
    }


    @Bean
    public StudentInfo studentInfo(){
        return new StudentInfo(this.student1());
    }
//
//    @Bean
//    public Student student3(){
//        List hobbys = new ArrayList();
//        hobbys.add("독서"); hobbys.add("음악감상");
//        Student student = new Student("홍길자", 22, hobbys);
//        student.setHeight(160);   student.setWeight(50);
//        return student;
//    }
//
    @Bean
    public Family family(){

        Family family = new Family("홍아빠", "홍엄마");
        family.setSisterName("홍누나");
        family.setBrotherName("홍형");
        return family;
    }

}
