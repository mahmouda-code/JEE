package com.example.hr.controller;

import com.example.hr.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (EmployeeService.authenticate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", EmployeeService.getUserRole(username));
            response.sendRedirect("dashboard.jsp");
        } else {
            request.setAttribute("error", "Identifiants incorrects");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}