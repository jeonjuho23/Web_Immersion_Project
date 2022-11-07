package com.example.loginandboard.admin.command;

import com.example.loginandboard.admin.dao.AdminDAO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminMemberDeleteCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");
        HttpServletResponse response = (HttpServletResponse) model.getAttribute("response");

        AdminDAO admindao = new AdminDAO();

        boolean isSuccess = admindao.deleteMember((String) request.getParameter("id"));

        response.setContentType("text/html;charset=euc-kr");
        PrintWriter out=response.getWriter();
        out.println("<script>");

        if(!isSuccess) {
            System.out.println("멤버 삭제 실패");
            out.println("alert('멤버 삭제에 실패했습니다.');");
            return;
        }

        out.println("alert('멤버 삭제에 성공했습니다.');");
        out.println("location.href='/admin/member/list'");
        out.println("</script>");
        out.close();

    }
}
