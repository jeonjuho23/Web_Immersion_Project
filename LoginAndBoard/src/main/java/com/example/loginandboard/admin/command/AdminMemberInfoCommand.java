package com.example.loginandboard.admin.command;

import com.example.loginandboard.admin.dao.AdminDAO;
import com.example.loginandboard.overall.command.Command;
import com.example.loginandboard.overall.dto.MemberInfoDTO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminMemberInfoCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        HttpServletRequest request = (HttpServletRequest) model.getAttribute("request");

        AdminDAO admindao = new AdminDAO();

        MemberInfoDTO memberinfo;

        memberinfo = admindao.getMemberInfo((String) request.getParameter("id"));

        if(memberinfo == null) {
            System.out.println("멤버 정보 가져오기 실패");
            return;
        }

        model.addAttribute("memberinfo", memberinfo);
    }
}
