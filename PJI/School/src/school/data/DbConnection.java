package school.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/school";
	private static final String USER = "root";
	private static final String PASSWORD = "senai";
	//
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	public static void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
