package com.example.loginandboard.overall.command;

import org.springframework.ui.Model;

import java.io.IOException;

public interface Command {
    void execute(Model model) throws IOException;
}
