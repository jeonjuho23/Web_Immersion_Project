package com.example.loginandboard.board.command;

import com.example.loginandboard.board.dao.BoardDAO;
import com.example.loginandboard.board.dto.BoardDTO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardModifyCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");
        HttpServletResponse response = (HttpServletResponse) model.getAttribute("response");

        request.setCharacterEncoding("UTF-8");
        boolean result = false;

        int num=Integer.parseInt(request.getParameter("BOARD_NUM"));

        BoardDAO boarddao=new BoardDAO();
        BoardDTO boarddata=new BoardDTO();

        boolean usercheck=boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));

        if(usercheck==false){
            response.setContentType("text/html;charset=euc-kr");
            PrintWriter out=response.getWriter();
            out.println("<script>");
            out.println("alert('������ ������ �����ϴ�.');");
            out.println("location.href='/board/list';");
            out.println("</script>");
            out.close();
            return;
        }

        boarddata.setBOARD_NUM(num);
        boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
        boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));

        result = boarddao.boardModify(boarddata);
        if(result==false){
            System.out.println("�Խ��� ���� ����");
            return;
        }
        System.out.println("�Խ��� ���� �Ϸ�");
    }
}
