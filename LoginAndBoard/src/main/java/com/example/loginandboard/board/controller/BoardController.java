package com.example.loginandboard.board.controller;

import com.example.loginandboard.board.command.*;
import com.example.loginandboard.board.command.view.*;
import com.example.loginandboard.overall.command.Command;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/board")
public class BoardController {
    Command command;

    @RequestMapping("/list")
    public String listBoard(HttpServletRequest request, Model model) throws IOException  {
        command = new BoardListCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "board/list";
    }

    @RequestMapping("/write")
    public String writeViewBoard(Model model) {
        return "board/write";
    }

    @RequestMapping("/add")
    public String writeBoard(HttpServletRequest request, Model model) throws IOException  {
        command = new BoardWriteCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "redirect:/board/list";
    }

    @RequestMapping("/delete/view")
    public String deleteView(HttpServletRequest request, Model model) {
        model.addAttribute("request", request);
        return "board/delete";
    }

    @RequestMapping("/delete")
    public String deleteBoard(HttpServletRequest request, Model model) throws IOException  {
        command = new BoardDeleteCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "redirect:/board/list";
    }

    @RequestMapping("/modify/view")
    public String modifyView(HttpServletRequest request, Model model) throws IOException {
        command = new BoardModifyViewCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "board/modify";
    }

    @RequestMapping("/modify")
    public String modifyBoard(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException  {
        command = new BoardModifyCommand();
        model.addAttribute("request", request);
        model.addAttribute("response", response);
        command.execute(model);

        return "redirect:/board/list";
    }

    @RequestMapping("/detail")
    public String detailBoard(HttpServletRequest request, Model model) throws IOException  {
        command = new BoardDetailCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "board/view";
    }


    // ------------ reply --------------

    @RequestMapping("/reply/view")
    public String replyView(HttpServletRequest request, Model model) throws IOException {
        command = new BoardReplyViewCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "board/reply";
    }

    @RequestMapping("/reply")
    public String replyBoard(HttpServletRequest request, Model model) throws IOException {
        command = new BoardReplyCommand();
        model.addAttribute("request", request);
        command.execute(model);

        return "redirect:/board/list";
    }
}
