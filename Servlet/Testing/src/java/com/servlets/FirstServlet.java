package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import java.util.Date;

public class FirstServlet implements Servlet {

    ServletConfig conf;

    @Override
    public void init(ServletConfig conf) {
        this.conf = conf;
        System.out.println("Creating Object...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {

        System.out.println("Servicing....");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my output from servlet method");
        out.println("<h1>Todays date and time is " + new Date().toString() + "</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return conf;
    }

    @Override
    public String getServletInfo() {
        System.out.println("This servlet is created by me");
        return "My First Servlet";
    }
}