package enrollmentrenovation.data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/enrollmentrenovation";
    private static String USER = "root";
    private static String PASSWORD = "worldskills";

    public static java.sql.Connection openConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void closeConnection(java.sql.Connection connection) throws SQLException {
        connection.close();
    }
}
