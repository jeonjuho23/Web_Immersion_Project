package com.example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllController {

    @RequestMapping(value = "/home")
    public String goHome(){
        return "home";
    }
}
