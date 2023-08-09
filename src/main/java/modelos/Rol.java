package modelos;

public class Rol {
    private int id_rol;
    private String descripcion;
    private int acceso;

    public Rol() {
    }
    public Rol(String descripcion, int acceso) {
        this.descripcion = descripcion;
        this.acceso = acceso;
    }
    public Rol(int id_rol, String descripcion, int acceso) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
        this.acceso = acceso;
    }
    public int getId_rol() {
        return id_rol;
    }
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getAcceso() {
        return acceso;
    }
    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }

    }