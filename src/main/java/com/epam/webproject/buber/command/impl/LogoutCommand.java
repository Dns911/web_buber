package com.epam.webproject.buber.command.impl;

import com.epam.webproject.buber.command.Command;
import com.epam.webproject.buber.controller.PagePath;
import jakarta.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.INDEX;
    }
}
