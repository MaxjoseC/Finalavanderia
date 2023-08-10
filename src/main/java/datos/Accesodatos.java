package datos;

import modelos.Rol;
import modelos.Tipoatencion;
import modelos.cliente;
import modelos.usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Accesodatos {
    private Conexion conexion;

    public Accesodatos(){
        conexion = new Conexion();
    }
    public List<Rol> obtenerRoles(){
        List<Rol> roles = new ArrayList<Rol>();
        try{
            final String SQL = "SELECT * FROM rol";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Rol rol = new Rol();
                rol.setId_rol(rs.getInt("id_rol"));
                rol.setDescripcion(rs.getString("descripcion"));
                rol.setAcceso(rs.getInt("acceso"));
                roles.add(rol);
            }

        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return roles;
    }
    public List<Tipoatencion> Tipoatencion(){
        List<Tipoatencion> tipoatencionlist = new ArrayList<Tipoatencion>();
        try{
            final String SQL = "SELECT * FROM tipoatencion";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Tipoatencion tipoatencion = new Tipoatencion();
                tipoatencion.setId_tipoatencion(rs.getInt("id_tipoatencion"));
                tipoatencion.setNombre(rs.getString("nombre"));
                tipoatencionlist.add(tipoatencion);
            }

        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return tipoatencionlist;
    }

    public cliente crearcliente(cliente cliente){
        try{
            final String SQL = "INSERT INTO cliente (id_cliente, nombre, apellido) VALUES (?,?,?)";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                cliente.setId_cliente(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }

    public cliente getCliente_id(int id_cliente){
        try{
            final String SQL = "SELECT * FROM cliente WHERE id_cliente =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, id_cliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                cliente cliente = new cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                return cliente;
            }

        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }

    public cliente getClientedatos(String nombre, String apellido){
        try{
            final String SQL = "SELECT * FROM cliente WHERE nombre =? OR apellido =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                cliente cliente = new cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                return cliente;
            }

        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean actualizarCliente(cliente cliente){
        try{
            final String SQL = "UPDATE cliente SET nombre =?, apellido =? WHERE id_cliente =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getId_cliente());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    /**
     * Eliminar un cliente a partir del nombre y apellido
     * @param nombre,apellido del cliente
     * @return true si borra el cliente, faalse en el caso contrario
     */
    public boolean borrarCliente(String nombre, String apellido){
        try{
            final String SQL = "DELETE FROM cliente WHERE nombre =? OR apellido =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    /**
     * crear un nuevo usuario
     * @param usuario usario a crear
     * @return usuario usuario creado
     */
    public usuario crearUsuario(usuario usuario){
        try{
            final String SQL = "INSERT INTO usuario (id_usuario, correo, clave) VALUES (?,?,?)";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, usuario.getId_usuario());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getClave());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                usuario.setId_usuario(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }
}
