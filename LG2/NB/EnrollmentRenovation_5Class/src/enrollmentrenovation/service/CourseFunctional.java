package enrollmentrenovation.service;
import java.sql.SQLException;
import java.util.List;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.Discipline;
public interface CourseFunctional {
	public Course register(int Id, String Name, int IdSchool) throws ClassNotFoundException, SQLException;
	public List<Course> searchAll() throws SQLException, ClassNotFoundException;
	public List<Course> filter(String Name) throws SQLException, ClassNotFoundException;
	public void update(int Id, String Name, int IdSchool) throws ClassNotFoundException, SQLException;
	public void delete(String Name) throws ClassNotFoundException, SQLException;
        public void addDiscipline(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) throws SQLException;
        public void deleteDiscipline(int IdCourse, int IdDiscipline) throws SQLException;
}