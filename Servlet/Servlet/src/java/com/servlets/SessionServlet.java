package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
            
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        
        String url = resp.encodeURL("profile");
        out.println("<h1>Session Created</h1>");
        out.println("<h2>Hello "+ username+ "<h2>");
        out.println("<a href='"+ url + "'>Go to Profile</a>");
    }
}
