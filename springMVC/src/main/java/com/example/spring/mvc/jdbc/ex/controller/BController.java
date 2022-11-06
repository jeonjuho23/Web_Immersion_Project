package com.example.spring.mvc.jdbc.ex.controller;

import com.example.spring.mvc.jdbc.ex.command.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BController {

    private BCommand command;

    @RequestMapping("/list")
    public String list(Model model) {
        System.out.println("/list");
        command = new BListCommand();
        command.excute(model);

        return "list";
    }

}
