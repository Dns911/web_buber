package com.epam.webproject.buber.command.impl;

import com.epam.webproject.buber.command.Command;
import com.epam.webproject.buber.controller.PagePath;
import com.epam.webproject.buber.service.UserService;
import com.epam.webproject.buber.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
       String login = request.getParameter("login");
       String password = request.getParameter("pass");
        UserService userService = UserServiceImpl.getInstance();
        String page;
        if (userService.authenticate(login, password)){
            request.setAttribute("user", login);
            page = PagePath.MAIN;
        } else {
            request.setAttribute("login_msg", "incorrect login or pass");
            page = PagePath.INDEX;
        }
        return page;
    }
}
