package controllers;

import dao.UserDAO;
import helper.EmailUtility;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet(name = "Recuperar", urlPatterns = {"/recuperar", "/enviar_recuperacion"})
public class Recuperar extends HttpServlet {
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
    
    @Override
    public void init() {
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/recuperar":
                request.getRequestDispatcher("/WEB-INF/recuperar.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/enviar_recuperacion":
                String correo = request.getParameter("correo");

                UserDAO userDao = new UserDAO();
                JSONObject json = new JSONObject();
                json.put("test", correo);

                try {
                    if(userDao.checarCorreo(correo)) {
                        String nueva_pass = userDao.resetPass(correo);
                        
                        if(!nueva_pass.equals("")) {
                            String recipient = correo;
                            String subject = "Recuperación de contraseña";

                            String content = "Estos son sus nuevos datos de ingreso<br><br>" +
                                    "<b>Correo: </b>" + correo + "<br>" +
                                    "<b>Contraseña temporal: </b>" + nueva_pass + "<br>" + 
                                    "<br>Debe cambiar su contraseña después de ingresar.";

                            String message = "";

                            try {
                                EmailUtility.sendEmail(host, port, email, name, pass,
                                        recipient, subject, content);
                                json.put("resultado", true);
                                json.put("mensaje", "Email de recuperación enviado.");
                            } catch (UnsupportedEncodingException | MessagingException ex) {
                                json.put("resultado", false);
                                json.put("error", ex.getMessage());
                            } 
                        }
                        else {
                            json.put("resultado", false);
                            json.put("error", "No se pudo reiniciar la contraseña.");
                        }
                    }
                    else {
                        json.put("resultado", false);
                        json.put("error", "No se encuentra el correo ingresado.");
                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    throw new ServletException(ex);
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
