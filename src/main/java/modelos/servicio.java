package modelos;

import java.time.LocalDateTime;
public class servicio {
    private int id_servicio;
    private String descripcion;
    private LocalDateTime fechaHoraRecepcion;
    private LocalDateTime fechaHoraEntrega;
    private int id_cliente;
    private int id_empleado;

    public servicio(){
    }
    public servicio(String descripcion, LocalDateTime fechaHoraRecepcion, LocalDateTime fechaHoraEntrega, int id_cliente, int id_empleado) {
        this.descripcion = descripcion;
        this.fechaHoraRecepcion = fechaHoraRecepcion;
        this.fechaHoraEntrega = fechaHoraEntrega;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
    }

    public servicio(int id_servicio, String descripcion, LocalDateTime fechaHoraRecepcion, LocalDateTime fechaHoraEntrega, int id_cliente, int id_empleado) {
        this.id_servicio = id_servicio;
        this.descripcion = descripcion;
        this.fechaHoraRecepcion = fechaHoraRecepcion;
        this.fechaHoraEntrega = fechaHoraEntrega;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHoraRecepcion() {
        return fechaHoraRecepcion;
    }

    public void setFechaHoraRecepcion(LocalDateTime fechaHoraRecepcion) {
        this.fechaHoraRecepcion = fechaHoraRecepcion;
    }

    public LocalDateTime getFechaHoraEntrega() {
        return fechaHoraEntrega;
    }

    public void setFechaHoraEntrega(LocalDateTime fechaHoraEntrega) {
        this.fechaHoraEntrega = fechaHoraEntrega;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
}
