package com.example.demo333.controller;

import java.io.*;

import com.example.demo333.command.Command;
import com.example.demo333.command.CommandType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/calc")
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
//        String str1 = req.getParameter( "num1");
//        String str2 = req.getParameter( "num2");
//        String mathOperator = req.getParameter( "mathOperator");
//        String b = req.getParameter("but");
//        int n1 = Integer.parseInt(str1);
//        int n2 = Integer.parseInt(str2);
//        int m = 0;
//        switch (mathOperator){
//            case "+": m = n1 + n2;
//            break;
//            case "-": m = n1 - n2;
//            break;
//            case "x": m = n1 * n2;
//            break;
//            case "/": m = n1 / n2;
//            break;
//        }
        


//        try {
//            req.setAttribute("result", m);
//            req.setAttribute("upper", b);
//            req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }

        String commandStr = req.getParameter("command");
        Command command = CommandType.define(commandStr);
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req,resp);
    }

    public void destroy() {
    }
}