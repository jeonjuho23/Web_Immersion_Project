package com.example.loginandboard.admin.command;

import com.example.loginandboard.admin.dao.AdminDAO;
import com.example.loginandboard.overall.command.Command;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class AdminMemberListCommand implements Command {
    @Override
    public void execute(Model model) throws IOException {
        AdminDAO admindao = new AdminDAO();

        List memberlist = admindao.getMemberList();

        if(memberlist == null) {
            System.out.println("리스트 가져오기 실패");
            return;
        }

        model.addAttribute("memberlist", memberlist);
    }
}
