package com.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;

public class ThirdServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("This is Servlet using httpservlet...");
        res.setContentType("text/html");
        PrintWriter out= res.getWriter();
        out.println("<h1>This is get method of my servlet</h1>");
    }
}
