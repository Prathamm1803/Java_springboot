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

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String terms = req.getParameter("terms");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        if (terms != null) {
            out.println("<h3>Form Data:</h3>");
            out.println("Username: " + username + "<br>");
            out.println("Password: " + password + "<br>");
            out.println("Email: " + email + "<br>");
            out.println("Gender: " + gender + "<br>");
            out.println("Course: " + course + "<br>");
            out.println("Terms: " + terms + "<br>");
            
            RequestDispatcher rd = req.getRequestDispatcher("storage");
            rd.forward(req, resp);
        } else {
            out.println("<h1>You havent accepted our T&C</h1>");
            RequestDispatcher rd = req.getRequestDispatcher("form.html");
            rd.include(req, resp);
        }
    }
}