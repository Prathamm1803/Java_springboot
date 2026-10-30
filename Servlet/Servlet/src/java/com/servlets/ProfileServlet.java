package com.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        
        out.println("<h1>Profile Page</h1>");
        out.println("<h2>Welcome " + username + "</h2>");
    }
}
