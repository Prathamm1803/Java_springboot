package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String username = req.getParameter("username");
        String course = (String)req.getAttribute("course");
        String terms = req.getParameter("terms");

        if (terms != null) {
            req.setAttribute("username", username);
            req.setAttribute("course", course);
            
            RequestDispatcher rd = req.getRequestDispatcher("storage");
            rd.forward(req, resp);
        } else {
            out.println("<h1>You havent accepted our T&C</h1>");
            RequestDispatcher rd = req.getRequestDispatcher("form.html");
            rd.include(req, resp);
        }
    }
}