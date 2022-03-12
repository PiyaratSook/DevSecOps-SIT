package controllers;

import dao.User;
import dao.UserDAO;
import helper.AppHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Cuenta", urlPatterns = {"/cuenta", "/datos_cuenta"})
public class Cuenta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect(AppHelper.baseUrl() + "login");
        }
        else {
            User user = (User) session.getAttribute("user");
            request.setAttribute("nombre", user.getNombre());
            request.setAttribute("apellidos", user.getApellidos());
            request.setAttribute("correo", user.getCorreo());
            request.getRequestDispatcher("/WEB-INF/cuenta.jsp").forward(request, response);
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
        
        User usuario = (User) session.getAttribute("user");
        
        switch (request.getServletPath()) {
            case "/datos_cuenta" :
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String correo = request.getParameter("correo");
                int id_usuario = usuario.getId();
                
                UserDAO userDAO = new UserDAO();

                try {
                    if(userDAO.cambiarDatos(nombre, apellidos, correo, id_usuario)) {
                        usuario.setNombre(nombre);
                        usuario.setApellidos(apellidos);
                        usuario.setCorreo(correo);
                        session.setAttribute("user", usuario);
                        request.setAttribute("resultado", Boolean.TRUE);
                        request.setAttribute("mensaje", "Datos actualizados con éxito"); 
                    }
                    else {
                        request.setAttribute("resultado", Boolean.FALSE);
                        request.setAttribute("mensaje", "No se pudieron actualizar los datos, vuelve a intentarlo");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    request.setAttribute("resultado", Boolean.FALSE);
                    request.setAttribute("mensaje", "No se pudieron actualizar los datos, vuelve a intentarlo");
                    Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    request.setAttribute("nombre", usuario.getNombre());
                    request.setAttribute("apellidos", usuario.getApellidos());
                    request.setAttribute("correo", usuario.getCorreo());
                    request.getRequestDispatcher("/WEB-INF/cuenta.jsp").forward(request, response);
                }  
                
                break;
        }
    }
}
