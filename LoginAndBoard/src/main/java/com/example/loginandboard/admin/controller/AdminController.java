package com.example.loginandboard.admin.controller;

import com.example.loginandboard.admin.command.AdminMemberDeleteCommand;
import com.example.loginandboard.admin.command.AdminMemberInfoCommand;
import com.example.loginandboard.admin.command.AdminMemberListCommand;
import com.example.loginandboard.overall.command.Command;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/member/list")
    public String getMemberList(Model model) throws IOException  {
        Command command = new AdminMemberListCommand();
        command.execute(model);

        return "admin/member/list";
    }

    @RequestMapping("/member/info")
    public String getMemberInfo(HttpServletRequest request, Model model) throws IOException  {
        Command command = new AdminMemberInfoCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "admin/member/info";
    }

    @RequestMapping("/member/delete")
    public String deleteMember(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        Command command = new AdminMemberDeleteCommand();
        model.addAttribute("request", request);
        model.addAttribute("response", response);
        command.execute(model);

        return "redirect:/admin/member/list";
    }


}
