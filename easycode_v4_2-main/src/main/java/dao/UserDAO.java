package dao;

import helper.AppHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3309/easycode?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&characterEncoding=UTF-8&allowPublicKeyRetrieval=true";
    private final String dbUser = "root";
    private final String dbPassword = "123456";
    
    public User checkLogin(String correo, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM usuarios WHERE correo = ? and password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, correo);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            User user = null;

            if (result.next()) {
                user = new User();
                user.setId(result.getInt("id_usuario"));
                user.setNombre(result.getString("nombre"));
                user.setApellidos(result.getString("apellidos"));
                user.setCorreo(correo);
                user.setTipo_usuario(result.getString("tipo_usuario"));
                user.setReiniciar(result.getInt("reiniciar_pass"));
            }

            connection.close();

            return user;
        }
    }
    
    public User registrarUsuario(String nombre, String apellidos, String correo, String password) throws 
            ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "INSERT INTO usuarios(nombre, apellidos, correo, password, tipo_usuario) values (?, ?, ?, MD5(?), 'usuario')";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, correo);
            statement.setString(4, password);

            int insert = statement.executeUpdate();
            User user = null;

            if (insert > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                     user = new User();
                    user.setNombre(nombre);
                    user.setApellidos(apellidos);
                    user.setCorreo(correo);
                    user.setId(generatedKeys.getInt(1));
                    user.setTipo_usuario("usuario");
                    user.setReiniciar(0);
                }
            } 

            connection.close();

            return user;
        }
    }
    
    public boolean checarCorreo(String correo) throws 
            ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM usuarios WHERE correo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, correo);

            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                connection.close();
                return true;
            } 
            
            connection.close();
        }
        return false;
    }
    
    public String resetPass(String correo) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String nueva_pass = AppHelper.randomString(10);

            String sql = "UPDATE usuarios SET password = MD5(?), reiniciar_pass = 1 WHERE correo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nueva_pass);
            statement.setString(2, correo);

            int update = statement.executeUpdate();

            if (update == 0) {
                nueva_pass = "";
            } 

            connection.close();
            return nueva_pass;
        }
    }
    
    public Boolean cambiarContra(String correo, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "UPDATE usuarios SET password = MD5(?), reiniciar_pass = 0 WHERE correo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, correo);

            int update = statement.executeUpdate();

            if (update == 1) {
               connection.close();
               return true;
            }  
            
            connection.close();
        } 
        return false;
    }
    
    public Boolean checarContra(String correo, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = MD5(?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, correo);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                connection.close();
                return true;
            }  
            
            connection.close();
        } 
        return false;
    }
    
    public Boolean cambiarDatos(String nombre, String apellidos, String correo, int id_usuario) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, correo = ? WHERE id_usuario = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, correo);
            statement.setInt(4, id_usuario);

            int update = statement.executeUpdate();

            if (update == 1) {
               connection.close();
               return true;
            }  
            
            connection.close();
        } 
        return false;
    }
    
    public int conteoUsuarios() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT COUNT(*) as conteo FROM usuarios";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getInt("conteo");
            }  
            
            connection.close();
        } 
        return 0;
    } 
    
    public List<User> listaUsuarios() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        List<User> usuarios = new ArrayList<User>();
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT nombre, apellidos, correo, tipo_usuario FROM usuarios";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();
            User user;
            
            while(result.next()) {
                user = new User();
                user.setNombre(result.getString("nombre"));
                user.setApellidos(result.getString("apellidos"));
                user.setCorreo(result.getString("correo"));
                user.setTipo_usuario(result.getString("tipo_usuario"));
                usuarios.add(user);
            }  
            
            connection.close();
        } 
        return usuarios;
    } 
}
