package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDAO;
import helper.AppHelper;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CambiarContra", urlPatterns = {"/cambiar_contra", "/cambio_pass"})
public class CambiarContra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect(AppHelper.baseUrl() + "login");
        }
        else {
            request.getRequestDispatcher("/WEB-INF/cambiarcontra.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect(AppHelper.baseUrl() + "login");
            return;
        }
        
        switch (request.getServletPath()) {
            case "/cambio_pass":
                User usuario = (User) session.getAttribute("user");

                String correo = usuario.getCorreo();
                String password = request.getParameter("nuevoPassword");

                UserDAO userDao = new UserDAO();

                try {
                    if(userDao.cambiarContra(correo, password) == true){
                        if(usuario.getTipo_usuario().equals("admin")) {
                            response.sendRedirect(AppHelper.baseUrl() + "admin"); 
                        }
                        else {
                            response.sendRedirect(AppHelper.baseUrl() + "plataforma");
                        }
                    }
                    else {
                        request.setAttribute("mensaje", "Vuelve a intentarlo.");
                        request.getRequestDispatcher("/WEB-INF/cambiarcontra.jsp").forward(request, response);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new ServletException(ex);
                }
                break;
        }

    }

}
