package enrollmentrenovation.data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/enrollmentrenovation";
    private static String USER = "root";
    private static String PASSWORD = "";

    public static java.sql.Connection openConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void closeConnection(java.sql.Connection connection) throws SQLException {
        connection.close();
    }
}
