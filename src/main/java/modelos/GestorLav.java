package modelos;

import datos.Accesodatos;

import java.util.List;

public class GestorLav {
    private Accesodatos accesodatos ;

    public GestorLav(){
        accesodatos = new Accesodatos();
    }
    public List<Rol> getRolList(){
        return accesodatos.obtenerRoles();
    }
    public List<Tipoatencion> getTipoatencionList(){
        return accesodatos.Tipoatencion();
    }
    public cliente crearCliente(cliente cliente){
        return accesodatos.crearcliente(cliente);
    }
    public cliente getCliente_id(int id_cliente){
        return accesodatos.getCliente_id(id_cliente);
    }
    public cliente getClientedatos(String nombre, String apellido){
        return accesodatos.getClientedatos(nombre, apellido);
    }
    public boolean actualizarCliente(cliente cliente){
        return accesodatos.actualizarCliente(cliente);
    }
    public boolean borrarCliente(String nombre, String apellido){
        return accesodatos.borrarCliente(nombre, apellido);
    }
    public usuario crearUsuario(usuario usuario){
        return accesodatos.crearUsuario(usuario);
    }
    public usuario iniciarSesion(String correo, String clave){
        return accesodatos.iniciarSesion(correo, clave);
    }
    public boolean borrarUsuario(String correo){
        return accesodatos.borrarUsuario(correo);
    }
    public empleado crearEmpleado(empleado empleado){
        return accesodatos.crearEmpleado(empleado);
    }
    public boolean modificarEmpleado(empleado empleado){
        return accesodatos.modificarEmpleado(empleado);
    }
    public List<empleado> getempleados(){
        return accesodatos.obtenerempleados();
    }
    public boolean borrarEmpleado(int id_empleado){
        return accesodatos.borrarEmpleado(id_empleado);
    }
    public atencion crearatencion(atencion atencion){
        return accesodatos.crearatencion(atencion);
    }
    public List<atencion> listaratencion(int id_servicio){
        return accesodatos.listaratencion(id_servicio);
    }
    public List<atencion> listatencionTipo(int id_Tipoatencion){
        return accesodatos.listatencionTipo(id_Tipoatencion);
    }
    public servicio crearServicio(servicio servicio){
        return accesodatos.crearServicio(servicio);
    }
    public List<servicio> listarServicioscliente(int id_cliente){
        return accesodatos.listarServicioscliente(id_cliente);
    }
    public List<servicio> listarServiciosEmpleado(int id_empleado){
        return accesodatos.listarServiciosEmpleado(id_empleado);
    }

    public usuario obtenerUsuariocorreo(String correo) {
        return accesodatos.obtenerUsuariocorreo(correo);
    }

    public List<cliente> getClientes() {
        return accesodatos.getClientes();
    }
}
