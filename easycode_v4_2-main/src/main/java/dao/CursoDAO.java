package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3309/easycode?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";
    private final String dbUser = "root";
    private final String dbPassword = "123456";
    
    public boolean agregarCurso(Curso curso) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "INSERT INTO cursos(nombre, costo, categoria, texto, descripcion) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, curso.getNombre());
            statement.setFloat(2, curso.getCosto());
            statement.setString(3, curso.getCategoria());
            statement.setString(4, curso.getTexto());
            statement.setString(5, curso.getDescripcion());

            int insert = statement.executeUpdate();

            if (insert > 0) {
                return true;
            } 

            connection.close();
        }
        return false;
    }
    
    public boolean borrarCurso(int id_curso) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "DELETE FROM cursos WHERE id_curso = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_curso);

            int insert = statement.executeUpdate();

            if (insert > 0) {
                return true;
            } 

            connection.close();
        }
        return false;
    }
    
    public List<Curso> obtenerCursos() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        List<Curso> cursos = new ArrayList<Curso>();
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM cursos";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            Curso curso;

            while(result.next()) {
                curso = new Curso();
                curso.setId_curso(result.getInt("id_curso"));
                curso.setNombre(result.getString("nombre"));
                curso.setDescripcion(result.getString("descripcion"));
                curso.setCategoria(result.getString("categoria"));
                curso.setCosto(result.getFloat("costo"));
                curso.setTexto(result.getString("texto"));
                cursos.add(curso);
            }

            connection.close();
        }
        return cursos;
    }
    
    public int conteoCursos() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        int conteo = 0;
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT COUNT(*) as conteo FROM cursos";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            if(result.next()) {
                conteo = result.getInt("conteo");
            }
            
            connection.close();
        }
        return conteo;
    }
    
    public Curso obtenerCurso(int id_curso) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Curso curso = null;
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM cursos WHERE id_curso = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_curso);
            
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                curso = new Curso();
                curso.setId_curso(result.getInt("id_curso"));
                curso.setNombre(result.getString("nombre"));
                curso.setDescripcion(result.getString("descripcion"));
                curso.setCategoria(result.getString("categoria"));
                curso.setCosto(result.getFloat("costo"));
                curso.setTexto(result.getString("texto"));
            }

            connection.close();
        }
        
        return curso;
    }
    
    public List<Curso> buscarCursos(String buscar) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        List<Curso> cursos = new ArrayList<Curso>();
        try(Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM cursos WHERE nombre LIKE ? OR descripcion LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, '%' + buscar + '%');
            statement.setString(2, '%' + buscar + '%');
            
            ResultSet result = statement.executeQuery();

            Curso curso;

            while(result.next()) {
                curso = new Curso();
                curso.setId_curso(result.getInt("id_curso"));
                curso.setNombre(result.getString("nombre"));
                curso.setDescripcion(result.getString("descripcion"));
                curso.setCategoria(result.getString("categoria"));
                curso.setCosto(result.getFloat("costo"));
                curso.setTexto(result.getString("texto"));
                cursos.add(curso);
            }

            connection.close();
        }
        return cursos;
    }
}
