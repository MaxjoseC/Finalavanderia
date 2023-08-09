package datos;

import modelos.Rol;

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
        try{
            final String SQL = "SELECT * FROM rol";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            List<Rol> roles = new ArrayList<Rol>();

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
    }
}
