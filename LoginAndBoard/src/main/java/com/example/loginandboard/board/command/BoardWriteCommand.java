package com.example.loginandboard.board.command;

import com.example.loginandboard.board.dao.BoardDAO;
import com.example.loginandboard.board.dto.BoardDTO;
import com.example.loginandboard.overall.command.Command;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BoardWriteCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");

        BoardDAO boarddao=new BoardDAO();
        BoardDTO boarddata=new BoardDTO();

        String realFolder="";
        String saveFolder= "boardupload";

        int fileSize=5*1024*1024;

        realFolder=request.getRealPath(saveFolder);

        boolean result=false;


        MultipartRequest multi=null;

        multi=new MultipartRequest(request,
                realFolder,
                fileSize,
                "UTF-8",
                new DefaultFileRenamePolicy());

        boarddata.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
        boarddata.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
        boarddata.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
        boarddata.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
        boarddata.setBOARD_FILE(
                multi.getFilesystemName((String)multi.getFileNames().nextElement()));

        result=boarddao.boardInsert(boarddata);

        if(result==false){
            System.out.println("�Խ��� ��� ����");
            return;
        }
        System.out.println("�Խ��� ��� �Ϸ�");
    }
}
