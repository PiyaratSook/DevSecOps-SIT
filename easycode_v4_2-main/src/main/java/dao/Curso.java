package dao;

public class Curso {
    private int id_curso;
    private String nombre;
    private float costo;
    private String categoria;
    private String texto;
    private String descripcion;

    public Curso() {
        this.id_curso = -1;
        this.nombre = "";
        this.costo = 0;
        this.categoria = "";
        this.texto = "";
        this.descripcion = "";
    }

    public Curso(String nombre, float costo, String categoria, String texto, String descripcion) {
        this.nombre = nombre;
        this.costo = costo;
        this.categoria = categoria;
        this.texto = texto;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
