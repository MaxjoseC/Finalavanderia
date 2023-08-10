package modelos;

public class empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private double sueldo;
    private int id_rol;


    public empleado() {

    }
    public empleado(int id_empleado, String nombre, String apellido, double sueldo, int id_rol) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.id_rol = id_rol;

    }
    public empleado(String nombre, String apellido, double sueldo, int id_rol){
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.id_rol = id_rol;
    }
    public int getId_empleado() {
        return id_empleado;
    }
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public int getId_rol() {
        return id_rol;
    }
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

}
