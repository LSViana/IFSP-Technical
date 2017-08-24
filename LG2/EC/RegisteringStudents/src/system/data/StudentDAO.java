package system.data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import system.business.Student;
public class StudentDAO { // Student Data Access Object
	// Connection object
	private static Connection connection;
	// Insert
	public Student insert(Student student) throws ClassNotFoundException, SQLException {
		// Open the connection to this DML operation
		java.sql.Connection _connection = connection.openConnection();
		// Declaring the SQL stamement to be executed against database
		String insertCommand = "insert into Student values(?, ?, ?, ?);";
		// Receiving and setting the statement with the needed fields
		PreparedStatement stmt = _connection.prepareStatement(insertCommand);
		stmt.setString(1, student.getEnrollment());
		stmt.setString(2, student.getName());
		stmt.setString(3, student.getEmail());
		stmt.setString(4, student.getTelephone());
		// (actually) Executing the stamement against database
		stmt.executeUpdate();
		// Close connection after execute operations
		_connection.close();
		// Returning the object with database calculated fields 
		return student;
	}
	// Search All
	public List<Student> searchAll() throws SQLException, ClassNotFoundException {
		// Open the connection to this DML operation
		java.sql.Connection _connection = Connection.openConnection();
		// Declaring the final list to be returned as a common list of Student objects
		List<Student> result = new ArrayList<Student>();
		// Declaring the SQL statement to be executed against database
		String selectCommand = "select * from Student;";
		// The statement to actually execute the query against database
		PreparedStatement stmt = _connection.prepareStatement(selectCommand);
		// The object 'ResultSet' keeps the result from database as a set of rows, those can be accessed through the 'next()' method 
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			result.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		// Returning as result the list of students
		return result;
	}
	// Update
	// Search for Primary Key
	// Delete
	// Update
}
