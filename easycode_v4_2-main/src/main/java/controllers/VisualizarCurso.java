package controllers;

import dao.Curso;
import dao.CursoDAO;
import dao.User;
import dao.VentaDAO;
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

@WebServlet(name = "VisualizarCurso", urlPatterns = {"/vercurso"})
public class VisualizarCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect(AppHelper.baseUrl() + "login");
        }
        else {
            int id_venta =  Integer.parseInt(request.getParameter("id_venta"));
            int id_curso =  Integer.parseInt(request.getParameter("id_curso"));
            User usuario = (User) session.getAttribute("user");
            int id_usuario = usuario.getId();
            VentaDAO ventaDAO = new VentaDAO();
            try {
                if(ventaDAO.verificarVenta(id_venta, id_usuario, id_curso)) {
                    CursoDAO cursoDAO = new CursoDAO();
                    Curso curso = cursoDAO.obtenerCurso(id_curso);
                    if(curso != null) {
                        request.setAttribute("resultado", Boolean.TRUE);
                        request.setAttribute("nombre", curso.getNombre());
                        request.setAttribute("texto", curso.getTexto());
                    }
                    else {
                        request.setAttribute("resultado", Boolean.FALSE);
                        request.setAttribute("mensaje", "El curso solicitado no existe.");
                    }
                }
                else {
                    request.setAttribute("resultado", Boolean.FALSE);
                    request.setAttribute("mensaje", "No has comprado este curso.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                request.setAttribute("resultado", Boolean.FALSE);
                request.setAttribute("mensaje", "Error: " + ex.getMessage());
                Logger.getLogger(VisualizarCurso.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                request.getRequestDispatcher("/WEB-INF/vercurso.jsp").forward(request, response);
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
            return;
        }
    }
}
