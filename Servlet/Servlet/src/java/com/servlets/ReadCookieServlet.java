package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadCookieServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies(); 
        
        String username = null;
        if (cookies != null) {
            for (Cookie c: cookies) {
                if ("username".equals(c.getName())) {
                    username = c.getValue();
                    break;
                }    
            }
        }
        if (username != null) {
            out.println("<h1>Welcome "+ username + "</h1>");
        } else {
            out.println("<h1>Cookie not Found!</h1>");
        }
    }
}
