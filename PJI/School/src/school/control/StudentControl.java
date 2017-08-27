package school.control;
import java.sql.SQLException;
import java.util.List;

import school.model.Student;
public class StudentControl {
	public Student insert(Student student) throws ClassNotFoundException, SQLException {
		StudentDAO.insert(student);
		return student;
	}
	public List<Student> searchAll() throws ClassNotFoundException, SQLException {
		return StudentDAO.searchAll();
	}
}
