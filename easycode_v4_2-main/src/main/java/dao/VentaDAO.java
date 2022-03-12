package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3309/easycode?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";
    private final String dbUser = "root";
    private final String dbPassword = "123456";

    public boolean realizarVenta(int id_curso, int id_usuario) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "INSERT INTO ventas(id_curso, id_usuario, fecha_venta) VALUES(?, ?, NOW())";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_curso);
            statement.setInt(2, id_usuario);

            int insert = statement.executeUpdate();

            if (insert > 0) {
                return true;
            } 

            connection.close();
        }
        return false;
    }
    
    public Venta obtenerVenta(int id_venta) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Venta venta = null;
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM ventas WHERE id_venta = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_venta);
            
            ResultSet result = statement.executeQuery();
            
            if(result.next()) {
                venta = new Venta();
                venta.setId_venta(result.getInt("id_venta"));
                venta.setId_curso(result.getInt("id_curso"));
                venta.setFecha_venta(result.getString("fecha_venta"));
                venta.setId_usuario(result.getInt("id_usuario"));
            }

            connection.close();
        }
        
        return venta;
    }
    
    public List<Venta> obtenerVentas(int id_usuario) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        List<Venta> ventas = new ArrayList<Venta>();
        Venta venta;
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM ventas WHERE id_usuario = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_usuario);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()) {
                venta = new Venta();
                venta.setId_venta(result.getInt("id_venta"));
                venta.setId_curso(result.getInt("id_curso"));
                venta.setFecha_venta(result.getString("fecha_venta"));
                venta.setId_usuario(result.getInt("id_usuario"));
                ventas.add(venta);
            }

            connection.close();
        }
        
        return ventas;
    }
    
    public boolean verificarVenta(int id_venta, int id_usuario, int id_curso) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM ventas WHERE id_venta = ? AND id_usuario = ? AND id_curso = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_venta);
            statement.setInt(2, id_usuario);
            statement.setInt(3, id_curso);

            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return true;
            } 

            connection.close();
        }
        return false;
    }
    
    public int conteoVentas() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT COUNT(*) as conteo FROM ventas";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getInt("conteo");
            }  
            
            connection.close();
        } 
        return 0;
    } 
    
    public float sumaVentas() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT SUM(cursos.costo) as conteo FROM ventas INNER JOIN cursos ON (ventas.id_curso = cursos.id_curso)";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getFloat("conteo");
            }  
            
            connection.close();
        } 
        return 0;
    } 
    
   
}
