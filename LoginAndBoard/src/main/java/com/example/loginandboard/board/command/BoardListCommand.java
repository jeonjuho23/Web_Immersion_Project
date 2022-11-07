package com.example.loginandboard.board.command;

import com.example.loginandboard.board.dao.BoardDAO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class BoardListCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");

        BoardDAO boarddao=new BoardDAO();
        List boardlist;

        int page=1;
        int limit=10;

        if(request.getParameter("page")!=null){
            page=Integer.parseInt(request.getParameter("page"));
        }

        int listcount=boarddao.getListCount(); //�� ����Ʈ ���� �޾ƿ�.
        boardlist = boarddao.getBoardList(page,limit); //����Ʈ�� �޾ƿ�.

        //�� ������ ��.
        int maxpage=(int)((double)listcount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
        //���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
        int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
        //���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
        int endpage = maxpage;

        if (endpage>startpage+10-1) endpage=startpage+10-1;

        model.addAttribute("page", page);		  //���� ������ ��.
        model.addAttribute("maxpage", maxpage); //�ִ� ������ ��.
        model.addAttribute("startpage", startpage); //���� �������� ǥ���� ù ������ ��.
        model.addAttribute("endpage", endpage);     //���� �������� ǥ���� �� ������ ��.
        model.addAttribute("listcount",listcount); //�� ��.
        model.addAttribute("boardlist", boardlist);
    }
}
