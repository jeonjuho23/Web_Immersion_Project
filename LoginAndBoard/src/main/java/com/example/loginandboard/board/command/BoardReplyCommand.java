package com.example.loginandboard.board.command;

import com.example.loginandboard.board.dao.BoardDAO;
import com.example.loginandboard.board.dto.BoardDTO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BoardReplyCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");

        request.setCharacterEncoding("UTF-8");

        BoardDAO boarddao=new BoardDAO();
        BoardDTO boarddata=new BoardDTO();
        int result=0;

        boarddata.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
        boarddata.setBOARD_NAME(request.getParameter("BOARD_NAME"));
        boarddata.setBOARD_PASS(request.getParameter("BOARD_PASS"));
        boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
        boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
        boarddata.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
        boarddata.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
        boarddata.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));

        result=boarddao.boardReply(boarddata);
        if(result==0){
            System.out.println("���� ����");
            return;
        }
        System.out.println("���� �Ϸ�");
    }
}
