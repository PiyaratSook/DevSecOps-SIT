package controllers;

import dao.User;
import dao.UserDAO;
import helper.AppHelper;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Registro", urlPatterns = {"/registro"})
public class Registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/registro":
                HttpSession session;
                session = request.getSession(false);
                if(session == null || session.getAttribute("user") == null) {
                    request.getRequestDispatcher("/WEB-INF/registro.jsp").forward(request, response);
                }
                else {
                    response.sendRedirect(AppHelper.baseUrl() + "plataforma");
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");

            UserDAO userDao = new UserDAO();

            try {
                User user = userDao.registrarUsuario(nombre, apellidos, correo, password);

                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("iniciado", true);
                    response.sendRedirect(AppHelper.baseUrl() + "plataforma");
                } else {
                    String message = "Se produjo un error al registrarse";
                    request.setAttribute("message", message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registro.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                throw new ServletException(ex);
            }
    }
}
