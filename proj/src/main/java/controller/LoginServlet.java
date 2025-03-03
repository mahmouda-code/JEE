

//import service.AuthService;
//import model.Role;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.io.IOException;
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
   // protected void doPost(HttpServletRequest request, HttpServletResponse response) {
     //   String username = request.getParameter("username");
     //  String password = request.getParameter("password");

      //  Role role = AuthService.authenticate(username, password);

       // if (role != null) {
       //     HttpSession session = request.getSession();
         //   session.setAttribute("role", role); // Stocke le rôle dans la session

            // Redirige selon le rôle
         //   switch (role) {
          //      case ADMIN:
           //         response.sendRedirect("admin/dashboard.jsp");
                 //   break;
               // case MANAGER:
               //     response.sendRedirect("manager/dashboard.jsp");
               //     break;
           //     default:
            //        response.sendRedirect("employee/dashboard.jsp");
          //  }
     //   } else {
       //     request.setAttribute("error", "Identifiants invalides !");
       //     request.getRequestDispatcher("login.jsp").forward(request, response);
 //       }
 //   }

//}







