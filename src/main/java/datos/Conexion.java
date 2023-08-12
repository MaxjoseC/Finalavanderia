package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/lavanderiadb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Emajose12";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
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
