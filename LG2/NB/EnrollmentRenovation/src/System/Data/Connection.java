package System.Data;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/enrollmentrenovation";
    private static final String USER = "root";
    private static final String PASSWORD = "aluno";
    public static java.sql.Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void closeConnetion(java.sql.Connection connection) throws SQLException {
        connection.close();
    }
}