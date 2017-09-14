package system.service;
import java.sql.SQLException;
import java.util.List;
import system.business.Student;
public interface StudentFunctional {
	public Student register(String enrollment, String name, String email, String telephone) throws ClassNotFoundException, SQLException;
	public List<Student> searchAll() throws SQLException, ClassNotFoundException;
	public List<Student> filter(String filter) throws SQLException, ClassNotFoundException;
	public void update(String enrollment, String studentName, String email, String telephone) throws ClassNotFoundException, SQLException;
	public int delete(String enrollment) throws ClassNotFoundException, SQLException;
}
