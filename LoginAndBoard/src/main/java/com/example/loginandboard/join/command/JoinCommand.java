package com.example.loginandboard.join.command;

import com.example.loginandboard.join.dao.JoinDAO;
import com.example.loginandboard.overall.command.Command;
import com.example.loginandboard.overall.dto.MemberInfoDTO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JoinCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");
        HttpServletResponse response = (HttpServletResponse) model.getAttribute("response");

        JoinDAO joindao = new JoinDAO();
        MemberInfoDTO joinbean = new MemberInfoDTO();

        joinbean.setId(request.getParameter("id"));
        joinbean.setPw(request.getParameter("pw"));
        joinbean.setMail(request.getParameter("mail"));
        joinbean.setName(request.getParameter("name"));
        joinbean.setBirthday(
                request.getParameter("birth")+"/"+
                        request.getParameter("month")+"/"+
                        request.getParameter("day")
        );

        boolean isSuccess = joindao.join(joinbean);


        response.setContentType("text/html;charset=euc-kr");
        PrintWriter out=response.getWriter();

        if(!isSuccess) {
            System.out.println("회원가입 실패");
            out.println("<script>");
            out.println("alert('회원가입에 실패했습니다.');");
            out.println("location.href='/login/view';");
            out.println("</script>");
            out.close();
        }
    }
}
