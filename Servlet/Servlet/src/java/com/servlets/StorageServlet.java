package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class StorageServlet extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Your data is succesfully stored!...");
        
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String terms = req.getParameter("terms");
        
        String username = (String)req.getAttribute("username");
        String course = (String)req.getAttribute("course");
        out.println("<h3>Form Data:</h3>");
        out.println("Username: " + username + "<br>");
        out.println("Password: " + password + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Gender: " + gender + "<br>");
        out.println("Course: " + course + "<br>");
        out.println("Terms: " + terms + "<br>");
    }
}
