package com.example.loginandboard.join.controller;

import com.example.loginandboard.join.command.JoinCommand;
import com.example.loginandboard.overall.command.Command;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/join")
public class JoinController {

    @RequestMapping("/view")
    public String joinView(Model model){
        return "join/join";
    }

    @RequestMapping("/")
    public String join(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        Command command = new JoinCommand();
        model.addAttribute("request", request);
        model.addAttribute("response", response);
        command.execute(model);

        return "redirect:/login/view";
    }
}
