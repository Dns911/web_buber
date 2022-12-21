package com.epam.webproject.buber.controller;

import com.epam.webproject.buber.command.Command;
import com.epam.webproject.buber.command.CommandType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/controller")
public class HelloServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            process(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        resp.setContentType("text/html");

        String commandStr = req.getParameter("command");
        Command command = CommandType.define(commandStr.toUpperCase());
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req,resp);
    }

    public void destroy() {
    }
}