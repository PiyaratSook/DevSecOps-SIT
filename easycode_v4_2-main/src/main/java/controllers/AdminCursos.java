package controllers;

import dao.Curso;
import dao.CursoDAO;
import dao.User;
import helper.AppHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(name = "AdminCursos", urlPatterns = {"/admin_cursos", "/agregar_curso", "/borrar_curso"})
public class AdminCursos extends HttpServlet {

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
                request.getRequestDispatcher("/WEB-INF/admin/cursos.jsp").forward(request, response);
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
        
        CursoDAO cursoDAO = new CursoDAO();
        JSONObject json;
        
        switch (request.getServletPath()) {
            case "/agregar_curso" :
                String nombre = request.getParameter("nombre");
                float costo = Float.parseFloat(request.getParameter("costo"));
                String categoria = request.getParameter("categoria");
                String texto = request.getParameter("texto");
                String descripcion = request.getParameter("descripcion");
                
                Curso curso = new Curso(nombre, costo, categoria, texto, descripcion);
                json = new JSONObject();
                                
                try {
                    if(cursoDAO.agregarCurso(curso)) {
                        json.put("resultado", true);
                    }
                    else {
                        json.put("resultado", false);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(AdminCursos.class.getName()).log(Level.SEVERE, null, ex);
                    json.put("resultado", false);
                } finally {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter(); 
                    out.print(json);
                    out.flush();
                }
                break;
            case "/borrar_curso" :
                json = new JSONObject();
                int id_curso = Integer.parseInt(request.getParameter("id_curso"));
                try {
                    if(cursoDAO.borrarCurso(id_curso)) {
                        json.put("resultado", true);
                    }
                    else {
                        json.put("resultado", false);
                        json.put("mensaje", "No se pudo eliminar");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(AdminCursos.class.getName()).log(Level.SEVERE, null, ex);
                    json.put("resultado", false);
                    json.put("error", ex.getMessage());
                } finally {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter(); 
                    out.print(json);
                    out.flush();
                }
                break;
        }
    }
}
