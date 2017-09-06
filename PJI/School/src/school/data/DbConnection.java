package school.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
	// This is the standard Java Connector from MySQL official site, it should be included on the project if it is not yet 
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	// Here it goes the address of the database, it can be changed accordingly the need
	private static final String URL = "jdbc:mysql://localhost:3306/school";
	// Configure these two class variables to manage the 'user' and 'password' of MySQL Database
	private static final String USER = "root";
	private static final String PASSWORD = "worldskills";
	//
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	public static void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
