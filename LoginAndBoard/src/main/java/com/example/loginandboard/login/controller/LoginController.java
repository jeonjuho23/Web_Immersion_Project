package com.example.loginandboard.login.controller;

import com.example.loginandboard.login.command.LoginCommand;
import com.example.loginandboard.overall.command.Command;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/view")
    public String loginView(Model model){
        return "login/login";
    }

    @RequestMapping("/")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model)  throws IOException  {
        Command command = new LoginCommand();
        model.addAttribute("request", request);
        model.addAttribute("response", response);
        command.execute(model);

        return "redirect:/main/";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().invalidate();
        return "redirect:/login/view";
    }

}
