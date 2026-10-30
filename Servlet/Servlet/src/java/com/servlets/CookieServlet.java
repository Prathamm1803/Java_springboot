package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie cookie = new Cookie("username", "Pratham");
        resp.addCookie(cookie);
        
        resp.getWriter().println("<h1>Cookie Created!</h1>");
        
    }
}
