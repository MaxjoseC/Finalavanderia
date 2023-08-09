package modelos;

public class Tipoatencion {
    private int id_tipoatencion;
    private String nombre;
    public Tipoatencion(){

    }

    public Tipoatencion(int id_tipoatencion, String nombre) {
        this.id_tipoatencion = id_tipoatencion;
        this.nombre = nombre;
    }
    public int getId_tipoatencion() {
        return id_tipoatencion;
    }
    public void setId_tipoatencion(int id_tipoatencion) {
        this.id_tipoatencion = id_tipoatencion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
