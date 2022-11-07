package com.example.loginandboard.board.command;

import com.example.loginandboard.board.dao.BoardDAO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardDeleteCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");
        HttpServletResponse response = (HttpServletResponse) model.getAttribute("response");

        request.setCharacterEncoding("UTF-8");

        boolean result=false;
        boolean usercheck=false;
        int num=Integer.parseInt(request.getParameter("num"));

        BoardDAO boarddao=new BoardDAO();
        usercheck=boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));

        if(usercheck==false){
            response.setContentType("text/html;charset=euc-kr");
            PrintWriter out=response.getWriter();
            out.println("<script>");
            out.println("alert('������ ������ �����ϴ�.');");
            out.println("location.href='/board/list';");
            out.println("</script>");
            out.close();
        }

        result=boarddao.boardDelete(num);
        if(result==false){
            System.out.println("�Խ��� ���� ����");
        }
    }
}
