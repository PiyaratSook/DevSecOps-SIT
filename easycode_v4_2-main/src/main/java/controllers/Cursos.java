package controllers;

import dao.Curso;
import dao.CursoDAO;
import dao.User;
import dao.VentaDAO;
import helper.AppHelper;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "Cursos", urlPatterns = {"/cursos", "/obtener_cursos", "/conteo_cursos", "/comprar_curso", "/obtener_curso", "/buscar_cursos"})
public class Cursos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect(AppHelper.baseUrl() + "login");
        }
        else {
            request.getRequestDispatcher("/WEB-INF/cursos.jsp").forward(request, response);
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
        
        CursoDAO cursoDAO = new CursoDAO();
        JSONObject json;
        
        switch (request.getServletPath()) {
            case "/obtener_cursos" :
                List<Curso> cursos;
                json = new JSONObject();
                JSONArray cursosJSON = new JSONArray();
                
                try {
                    cursos = cursoDAO.obtenerCursos();
                    if(cursos.size()>=1) {
                        json.put("resultado", true);
                        
                        for (Curso cursoActual : cursos) {
                            JSONObject cursoJSON = new JSONObject();
                            cursoJSON.put("id_curso", cursoActual.getId_curso());
                            cursoJSON.put("nombre", cursoActual.getNombre());
                            cursoJSON.put("descripcion", cursoActual.getDescripcion());
                            cursoJSON.put("costo", String.format("%.02f", cursoActual.getCosto()));
                            cursoJSON.put("categoria", cursoActual.getCategoria());
                            cursoJSON.put("texto", cursoActual.getTexto());
                            cursosJSON.put(cursoJSON);
                        }
                        
                        json.put("cursos", cursosJSON);
                    }
                    else {
                        json.put("resultado", false);
                        json.put("mensaje", "No se encontraron cursos");
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
            case "/conteo_cursos" :
                json = new JSONObject();
                int conteo = 0;
                try {
                    conteo = cursoDAO.conteoCursos();
                    json.put("resultado", true);
                    json.put("conteo", conteo);
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
            case "/comprar_curso" :
                json = new JSONObject();
                VentaDAO ventaDAO = new VentaDAO();
                
                User user = (User) session.getAttribute("user");
                
                int id_curso = Integer.parseInt(request.getParameter("id_curso"));
                int id_usuario = user.getId();
                
                try {
                    if(ventaDAO.realizarVenta(id_curso, id_usuario)) {
                        json.put("resultado", true);
                    }
                    else {
                        json.put("resultado", false);
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
            case "/obtener_curso" :
                json = new JSONObject();
                
                id_curso = Integer.parseInt(request.getParameter("id_curso"));
                
                try {
                    Curso curso = cursoDAO.obtenerCurso(id_curso);
                    if(curso != null) {
                        json.put("resultado", true);
                        JSONObject cursoJSON = new JSONObject();
                        cursoJSON.put("id_curso", curso.getId_curso());
                        cursoJSON.put("nombre", curso.getNombre());
                        cursoJSON.put("descripcion", curso.getDescripcion());
                        cursoJSON.put("costo", String.format("%.02f", curso.getCosto()));
                        cursoJSON.put("categoria", curso.getCategoria());
                        cursoJSON.put("texto", curso.getTexto());
                        json.put("curso", cursoJSON);
                    }
                    else {
                        json.put("resultado", false);
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
            case "/buscar_cursos" :
                json = new JSONObject();
                cursosJSON = new JSONArray();
                
                String buscar = request.getParameter("buscar");
                
                try {
                    cursos = cursoDAO.buscarCursos(buscar);
                    if(cursos.size()>=1) {
                        json.put("resultado", true);
                        
                        for (Curso cursoActual : cursos) {
                            JSONObject cursoJSON = new JSONObject();
                            cursoJSON.put("id_curso", cursoActual.getId_curso());
                            cursoJSON.put("nombre", cursoActual.getNombre());
                            cursoJSON.put("descripcion", cursoActual.getDescripcion());
                            cursoJSON.put("costo", String.format("%.02f", cursoActual.getCosto()));
                            cursoJSON.put("categoria", cursoActual.getCategoria());
                            cursoJSON.put("texto", cursoActual.getTexto());
                            cursosJSON.put(cursoJSON);
                        }
                        
                        json.put("cursos", cursosJSON);
                    }
                    else {
                        json.put("resultado", false);
                        json.put("mensaje", "No se encontraron cursos");
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
