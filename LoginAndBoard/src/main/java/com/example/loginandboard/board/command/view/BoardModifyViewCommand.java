package com.example.loginandboard.board.command.view;

import com.example.loginandboard.board.dao.BoardDAO;
import com.example.loginandboard.board.dto.BoardDTO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BoardModifyViewCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");

        request.setCharacterEncoding("UTF-8");

        BoardDAO boarddao=new BoardDAO();
        BoardDTO boarddata;

        int num=Integer.parseInt(request.getParameter("num"));
        boarddata=boarddao.getDetail(num);

        if(boarddata==null){
            System.out.println("(����)�󼼺��� ����");
            return;
        }
        System.out.println("(����)�󼼺��� ����");

        model.addAttribute("boarddata", boarddata);
    }
}
