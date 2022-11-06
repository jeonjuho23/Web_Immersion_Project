package com.example.spring.mvc.jdbc.ex.command;

import com.example.spring.mvc.jdbc.ex.dao.BDao;
import com.example.spring.mvc.jdbc.ex.dto.BDto;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class BListCommand implements BCommand{
    @Override
    public void excute(Model model) {
        BDao dao = new BDao();
        ArrayList<BDto> dtos = dao.list();
        model.addAttribute("list", dtos);
    }
}
