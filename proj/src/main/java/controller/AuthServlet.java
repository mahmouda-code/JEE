package controller;


import model.User;
import service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")

public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserService.getInstance().authenticate(username, password);

        if (user != null) {
        	
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(user.getRole().name().toLowerCase() + "/dashboard");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}