package school.control;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import school.data.DbConnection;
import school.model.Student;
public class StudentDAO {
	private static Connection _connection;
	private static PreparedStatement prepStatement;
	public static Student insert(Student student) throws ClassNotFoundException, SQLException {
		_connection = DbConnection.openConnection();
		//
		String statement = "INSERT INTO Student VALUES(?, ?, ?);";
		prepStatement = _connection.prepareStatement(statement);
		prepStatement.setString(1, student.getEnrollment());
		prepStatement.setString(2, student.getStudentName());
		prepStatement.setInt(3, student.getAge());
		prepStatement.executeUpdate();
		//
		DbConnection.closeConnection(_connection);
		return student;
	}
	public static List<Student> searchAll() throws ClassNotFoundException, SQLException {
		List<Student> results = new ArrayList<>();
		_connection = DbConnection.openConnection();
		//
		String statement = "SELECT * FROM Student";
		prepStatement = _connection.prepareStatement(statement);
		ResultSet rs = prepStatement.executeQuery();
		while(rs.next()) {
			results.add(new Student(rs.getString(0), rs.getString(1), rs.getInt(2)));
		}
		//
		DbConnection.closeConnection(_connection);
		return results;
	}
}
