package datos;

import modelos.Rol;
import modelos.Tipoatencion;

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
}
