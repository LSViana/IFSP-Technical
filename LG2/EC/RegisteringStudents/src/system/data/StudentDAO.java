package system.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import system.business.Student;
import system.service.StudentFunctional;

public class StudentDAO implements StudentFunctional { // Student Data Access Object
	// Connection object
	private static Connection connection;

	@Override
	public Student register(String enrollment, String name, String email, String telephone)
			throws ClassNotFoundException, SQLException {
		return register(new Student(enrollment, name, email, telephone));
	}

	// Insert
	public Student register(Student student) throws ClassNotFoundException, SQLException {
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
	@Override
	public List<Student> searchAll() throws SQLException, ClassNotFoundException {
		// Open the connection to this DML operation
		java.sql.Connection _connection = Connection.openConnection();
		// Declaring the final list to be returned as a common list of Student objects
		List<Student> result = new ArrayList<Student>();
		// Declaring the SQL statement to be executed against database
		String selectCommand = "select * from Student;";
		// The statement to actually execute the query against database
		PreparedStatement stmt = _connection.prepareStatement(selectCommand);
		// The object 'ResultSet' keeps the result from database as a set of rows, those
		// can be accessed through the 'next()' method
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			result.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		// Returning as result the list of students
		return result;
	}

	// Search for Primary Key
	public List<Student> filter(String filter) throws SQLException, ClassNotFoundException {
		java.sql.Connection _connection = Connection.openConnection();
		List<Student> result = new ArrayList<Student>();
		String selectCommand = "select * from Student where enrollment like ?;";
		PreparedStatement stmt = _connection.prepareStatement(selectCommand);
		stmt.setString(1, "%" + filter + "%");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			result.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		Connection.closeConnection(_connection);
		return result;
	}

	// Delete
	public int delete(String enrollment) throws ClassNotFoundException, SQLException {
		java.sql.Connection _connection = Connection.openConnection();
		String deleteCommand = "delete from Student where enrollment like ?;";
		PreparedStatement stmt = _connection.prepareStatement(deleteCommand);
		stmt.setString(1, "%" + enrollment + "%");
		int changes = stmt.executeUpdate();
		Connection.closeConnection(_connection);
		return changes;
	}

	// Update
	public void update(String enrollment, String studentName, String email, String telephone)
			throws ClassNotFoundException, SQLException {
		if (enrollment.isEmpty())
			return;
		java.sql.Connection _connection = Connection.openConnection();
		String updateCommand = "update Student set 1 2 3 where enrollment like ?";
		PreparedStatement stmt = _connection.prepareStatement(updateCommand);
		if (studentName.isEmpty())
			updateCommand.replaceAll("1", "");
		else
			stmt.setString(1, studentName);
		if (email.isEmpty())
			updateCommand.replaceAll("2", "");
		else
			stmt.setString(2, email);
		if (telephone.isEmpty())
			updateCommand.replaceAll("3", "");
		else
			stmt.setString(3, telephone);
		stmt.setString(4, "%" + enrollment + "%");
		System.out.println(updateCommand);
		// stmt.executeUpdate();
		Connection.closeConnection(_connection);
	}
}
