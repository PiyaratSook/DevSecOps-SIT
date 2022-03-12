package controllers;

import dao.User;
import dao.UserDAO;
import helper.AppHelper;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/login", "/login_validation"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/login":
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/login_validation":
                String correo = request.getParameter("correo");
                String password = AppHelper.convetirMD5(request.getParameter("password"));

                UserDAO userDao = new UserDAO();

                try {
                    User user = userDao.checkLogin(correo, password);

                    if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        session.setAttribute("iniciado", true);
                        if(user.getReiniciar() == 1){
                            response.sendRedirect(AppHelper.baseUrl() + "cambiar_contra");
                        }
                        else {    
                            if(user.getTipo_usuario().equals("admin")) {
                               response.sendRedirect(AppHelper.baseUrl() + "admin"); 
                            }
                            else {
                                response.sendRedirect(AppHelper.baseUrl() + "plataforma");
                            }
                        }
                    } else {
                        String message = "Datos incorrectos";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new ServletException(ex);
                }
                break;
        }    
    }
}
