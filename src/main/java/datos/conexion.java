package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/proyectofinal";
    private static final String USER = "root";
    private static final String PASS = "Maxjose12";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASS);
    }
    public static void close(ResultSet rs) throws java.sql.SQLException {
        rs.close();
    }
    public static void close(PreparedStatement stmt) throws java.sql.SQLException {
        stmt.close();
    }
    public static void close(Connection conn) throws java.sql.SQLException {
        conn.close();
    }

}
