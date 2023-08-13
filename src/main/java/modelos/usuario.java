package modelos;

public class usuario {
    private int id_usuario;
    private String correo;
    private String clave;
    private int empleado_id_empleado;
    public usuario(){}

    public usuario(int id_usuario, String correo, String clave){
    this.id_usuario = id_usuario;
    this.correo = correo;
    this.clave = clave;
    }
    public usuario(String correo,String clave){
        this.correo = correo;
        this.clave = clave;
    }

    public usuario(int id_usuario, String correo, String clave, int empleado_id_empleado) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.clave = clave;
        this.empleado_id_empleado = empleado_id_empleado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_empleado() {
        return empleado_id_empleado;
    }

    public void setId_empleado(int empleado_id_empleado) {
        this.empleado_id_empleado = empleado_id_empleado;
    }
}



