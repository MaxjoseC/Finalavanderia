package datos;

import modelos.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setId_rol(rs.getInt("id_rol"));
                rol.setDescripcion(rs.getString("descripcion"));
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
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    /**
     * Eliminar un cliente a partir del nombre y apellido
     * @param nombre,apellido del cliente
     * @return true si borra el cliente, false en el caso contrario
     */
    public boolean borrarCliente(String nombre, String apellido){
        try{
            final String SQL = "DELETE FROM cliente WHERE nombre =? OR apellido =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, nombre);
            ps.setString(2, apellido);

            return ps.executeUpdate() > 0;

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
            final String SQL = "INSERT INTO usuario (correo, clave, empleado_id_empleado) VALUES (?,?,?)";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getClave());
            ps.setInt(3, usuario.getId_empleado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                usuario.setId_usuario(rs.getInt(1));
                return usuario;
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * inicia sesion a partir de los credenciales de un usuario
     * @param correo correo del usuario
     * @param clave del usuario
     */
    public usuario iniciarSesion(String correo, String clave){
        try{
            final String SQL = "SELECT * FROM usuario WHERE correo =? AND clave =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, correo);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                usuario usuario = new usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setCorreo(correo);
                usuario.setClave(clave);
                usuario.setId_empleado(rs.getInt("id_empleado"));
                return usuario;
            }

        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    /**
     * borrar usuario por correo
     * @param correo correo del usuario
     * @return true si lo eliminó correctamente, false de lo contrario
     */
    public boolean borrarUsuario(String correo){
        try{
            final String SQL = "DELETE FROM usuario WHERE correo =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, correo);

            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    /**obtener usuario a partir de su correo.
     * @param correo correo del usuario.
     * @return usuario usuario.
     *
     */
    public usuario obtenerUsuariocorreo(String correo){
        usuario usuario1 = null;
        try{
            final String SQL = "SELECT * FROM usuario WHERE correo =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                usuario usuario = new usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setCorreo(correo);
                usuario.setClave(rs.getString("clave"));
                usuario.setId_empleado(rs.getInt("id_empleado"));
                return usuario;
            }

        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    /** crear nuevo empleado.
     * @param empleado empleado a crear.
     * @return empleado empleado creado.
     */
    public empleado crearEmpleado(empleado empleado){
        try{
            final String SQL = "INSERT INTO empleado (nombre, apellido,sueldo, rol_idrol) VALUES (?,?,?,?)";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setDouble(3, empleado.getSueldo());
            ps.setInt(4, empleado.getId_rol());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                empleado.setId_empleado(rs.getInt(1));
                return empleado;
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    /**
     * modifica un empleado.
     * @param empleado empleado a modificar.
     * @return true si se modifico correctamente, false en caso contrario
     */
    public boolean modificarEmpleado(empleado empleado){
        try{
            final String SQL = "UPDATE empleado SET nombre =?, apellido =?, sueldo =? WHERE id_empleado =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setDouble(3, empleado.getSueldo());
            ps.setInt(4, empleado.getId_empleado());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    /**
     * recuperar todos los empleados en una List.
     * @return List<empleado> Lista de empleado.
     */
    public List<empleado> obtenerempleados() {
        List<empleado> empleados = new ArrayList<>();
        try{
            final String SQL = "SELECT * FROM empleado";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                empleado empleado = new empleado();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setSueldo(rs.getDouble("sueldo"));
                empleado.setId_rol(rs.getInt("rol_idrol"));
                empleados.add(empleado);
            }

        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return empleados;
    }
    /**
     * Elimina un empleado a partir de su Id_empleado.
     * @param id_empleado empleado a eliminar.
     * @return true si el empleado fue eliminado correctamente, false de lo contrario.
     */
    public boolean borrarEmpleado(int id_empleado){
        try{

            final String SQL = "DELETE FROM empleado WHERE id_empleado =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, id_empleado);

            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    public atencion crearatencion(atencion atencion){
        try{
            final String SQL = "INSERT INTO atencion (cantidad, precio, id_tipoatencion, id_servicio) VALUES (?,?,?,?)";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, atencion.getCantidad());
            ps.setDouble(2, atencion.getPrecio());
            ps.setInt(3, atencion.getId_Tipoatencion());
            ps.setInt(4, atencion.getId_servicio());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                atencion.setId_atencion(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    /**
     * listar atencion a partir del id
     * @param id_servicio id del servicio.
     * @return List<atencion> lista de atenciones.
     */
    public List<atencion> listaratencion(int id_servicio){
        List<atencion> atenciones = new ArrayList<>();
        try {
            final String SQL = "SELECT * FROM atencion WHERE id_servicio =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, id_servicio);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                atencion atencion = new atencion();
                atencion.setId_atencion(rs.getInt("id_atencion"));
                atencion.setCantidad(rs.getInt("cantidad"));
                atencion.setPrecio(rs.getDouble("precio"));
                atencion.setId_Tipoatencion(rs.getInt("id_tipoatencion"));
                atencion.setId_servicio(rs.getInt("id_servicio"));
                atenciones.add(atencion);
            }
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return atenciones;
    }
    /**
     * listar atencion a partir del id
     * @param id_Tipoatencion id del servicio.
     * @return List<atencion> lista de atenciones.
     */
    public List<atencion> listatencionTipo(int id_Tipoatencion){
        List<atencion> atenciones1 = new ArrayList<>();
        try{
            final String SQL = "SELECT * FROM atencion WHERE id_Tipoatencion =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, id_Tipoatencion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                atencion atencion = new atencion();
                atencion.setId_atencion(rs.getInt("id_atencion"));
                atencion.setCantidad(rs.getInt("cantidad"));
                atencion.setPrecio(rs.getDouble("precio"));
                atencion.setId_Tipoatencion(rs.getInt("id_tipoatencion"));
                atencion.setId_servicio(rs.getInt("id_servicio"));
                atenciones1.add(atencion);
            }
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        return atenciones1;
    }
    /**
     * crear un nuevo servicio
     * @param servicio servicio a crear nuevo
     * @return servicio servicio creado
     */
    public servicio crearServicio(servicio servicio){
        try{
            final String SQL = "INSERT INTO servicio (descripcion, fechaHoraRecepcion,fechaHoraEntrega, id_cliente,id_empleado) VALUES (?,DEFAULT,?,?,?,?)";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, servicio.getDescripcion());
            ps.setTimestamp(2, Timestamp.valueOf(servicio.getFechaHoraEntrega()));
            ps.setInt(3, servicio.getId_cliente());
            ps.setInt(4, servicio.getId_empleado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                servicio.setId_servicio(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    /**
     * listar servicios a partir del ID de un cliente
     * @param id_cliente del cliente
     * @return List<servicio> Lista de servicio
     */
    public List<servicio> listarServicioscliente(int id_cliente){
        List<servicio> servicios = new ArrayList<>();
        try{
            final String SQL = "SELECT * FROM servicio WHERE id_cliente =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, id_cliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                servicio servicio = new servicio();
                servicio.setId_servicio(rs.getInt("id_servicio"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setFechaHoraRecepcion(rs.getTimestamp("fechaHoraRecepcion").toLocalDateTime());
                servicio.setFechaHoraEntrega(rs.getTimestamp("fechaHoraEntrega").toLocalDateTime());
                servicio.setId_cliente(rs.getInt("id_cliente"));
                servicio.setId_empleado(rs.getInt("id_empleado"));
                servicios.add(servicio);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
    return servicios;

    }
    /**
     * listar servicios a partir del ID de un empleado
     * @param id_empleado del cliente
     * @return List<servicio> Lista de servicio
     */
    public List<servicio> listarServiciosEmpleado(int id_empleado){
        List<servicio> servicios1 = new ArrayList<>();
        try {
            final String SQL = "SELECT * FROM servicio WHERE id_empleado =?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(SQL);
            ps.setInt(1, id_empleado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                servicio servicio = new servicio();
                servicio.setId_servicio(rs.getInt("id_servicio"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setFechaHoraRecepcion(rs.getTimestamp("fechaHoraRecepcion").toLocalDateTime());
                servicio.setFechaHoraEntrega(rs.getTimestamp("fechaHoraEntrega").toLocalDateTime());
                servicio.setId_cliente(rs.getInt("id_cliente"));
                servicio.setId_empleado(rs.getInt("id_empleado"));
                servicios1.add(servicio);
            }
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return servicios1;
    }

}

