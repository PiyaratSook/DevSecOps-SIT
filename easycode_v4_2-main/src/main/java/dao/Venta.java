package dao;

public class Venta {
    private int id_venta;
    private int id_curso;
    private String fecha_venta;
    private int id_usuario;

    public Venta(int id_venta, int id_curso, String fecha_venta, int id_usuario) {
        this.id_venta = id_venta;
        this.id_curso = id_curso;
        this.fecha_venta = fecha_venta;
        this.id_usuario = id_usuario;
    }

    public Venta() {
        this.id_venta = -1;
        this.id_curso = -1;
        this.fecha_venta = "";
        this.id_usuario = -1;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
