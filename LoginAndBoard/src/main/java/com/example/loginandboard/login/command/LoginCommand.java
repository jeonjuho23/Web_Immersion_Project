package com.example.loginandboard.login.command;

import com.example.loginandboard.login.dao.LoginDAO;
import com.example.loginandboard.login.dto.LoginDTO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");
        HttpServletResponse response = (HttpServletResponse) model.getAttribute("response");

        LoginDAO logindao = new LoginDAO();
        LoginDTO loginbean = new LoginDTO();

        loginbean.setId((String)request.getParameter("id"));
        loginbean.setPw((String)request.getParameter("pw"));

        boolean isSuccess = logindao.login(loginbean);

        if(!isSuccess) {
            response.setContentType("text/html;charset=euc-kr");
            PrintWriter out=response.getWriter();
            System.out.println("로그인 실패");
            out.println("<script>");
            out.println("alert('로그인에 실패했습니다.');");
            out.println("location.href='/login/view';");
            out.println("</script>");
            out.close();
            return;
        }

        request.getSession().setAttribute("id", loginbean.getId());
    }
}
