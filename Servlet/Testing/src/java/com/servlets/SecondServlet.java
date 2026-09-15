package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

public class SecondServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet using Generic Servlet...");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is my second servlet using Generic Servlet");
    }
    
}
