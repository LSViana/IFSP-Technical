package enrollmentrenovation.service;
import java.util.List;
import enrollmentrenovation.business.Course;
public interface CourseFunctional {
	public Course register(int Id, String Name, int IdSchool) throws Exception;
	public List<Course> searchAll() throws Exception;
	public List<Course> filter(String Name) throws Exception;
	public void update(int Id, String Name, int IdSchool) throws Exception;
	public void delete(String Name) throws Exception;
        public void addDiscipline(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) throws Exception;
        public void deleteDiscipline(int IdCourse, int IdDiscipline) throws Exception;
}