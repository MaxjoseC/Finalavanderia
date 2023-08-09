package modelos;

public class atencion {
    private int id_atencion;
    private int cantidad;
    private double precio;
    private int id_Tipoatencion;
    private int id_servicio;

    public atencion(int cantidad, double precio, int id_Tipoatencion, int id_servicio) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_Tipoatencion = id_Tipoatencion;
        this.id_servicio = id_servicio;
    }

    public atencion(){
    }
    public atencion(int id_atencion, int cantidad, double precio, int id_Tipoatencion, int id_servicio){
        this.id_atencion = id_atencion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_Tipoatencion = id_Tipoatencion;
        this.id_servicio = id_servicio;
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_Tipoatencion() {
        return id_Tipoatencion;
    }

    public void setId_Tipoatencion(int id_Tipoatencion) {
        this.id_Tipoatencion = id_Tipoatencion;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
}
