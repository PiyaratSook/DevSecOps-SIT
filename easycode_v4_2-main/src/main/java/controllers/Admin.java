package controllers;

import dao.CursoDAO;
import dao.User;
import dao.UserDAO;
import dao.VentaDAO;
import helper.AppHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(name = "Admin", urlPatterns = {"/admin", "/conteos_admin"})
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect(AppHelper.baseUrl() + "login");
        }
        else {
            User usuario = (User) session.getAttribute("user");
            if(usuario.getTipo_usuario().equals("admin")) {
                JSONObject json = new JSONObject();
                UserDAO userDAO = new UserDAO();
                CursoDAO cursoDAO = new CursoDAO();
                VentaDAO ventaDAO = new VentaDAO();
                
                try {
                    int usuarios_registrados = userDAO.conteoUsuarios();
                    int cursos_registrados = cursoDAO.conteoCursos();
                    int ventas_realizadas = ventaDAO.conteoVentas();
                    float total_vendido = ventaDAO.sumaVentas();
                    List<User> usuarios = userDAO.listaUsuarios();
                    
                    request.setAttribute("usuarios_registrados", usuarios_registrados);
                    request.setAttribute("cursos_registrados", cursos_registrados);
                    request.setAttribute("ventas_realizadas", ventas_realizadas);
                    request.setAttribute("total_vendido", total_vendido);
                    request.setAttribute("usuarios", usuarios);
                           
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(AdminCursos.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
                }
            }
            else {
                response.sendRedirect(AppHelper.baseUrl() + "plataforma");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect(AppHelper.baseUrl() + "login");
        }
        else {
            User usuario = (User) session.getAttribute("user");
            if(!usuario.getTipo_usuario().equals("admin")) {
                response.sendRedirect(AppHelper.baseUrl() + "plataforma");
                return;
            }
        }
        
        switch (request.getServletPath()) {
            case "/conteos_admin" :
                JSONObject json = new JSONObject();
                UserDAO userDAO = new UserDAO();
                CursoDAO cursoDAO = new CursoDAO();
                VentaDAO ventaDAO = new VentaDAO();
                
                try {
                    int usuarios_registrados = userDAO.conteoUsuarios();
                    int cursos_registrados = cursoDAO.conteoCursos();
                    int ventas_realizadas = ventaDAO.conteoVentas();
                    float total_vendido = ventaDAO.sumaVentas();
                    List<User> usuarios = userDAO.listaUsuarios();
                    
                    request.setAttribute("usuarios_registrados", usuarios_registrados);
                    request.setAttribute("cursos_registrados", cursos_registrados);
                    request.setAttribute("ventas_realizadas", ventas_realizadas);
                    request.setAttribute("total_vendido", total_vendido);
                    request.setAttribute("usuarios", usuarios);
                           
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(AdminCursos.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
                }
                
        }
    }
}
