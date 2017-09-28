package enrollmentrenovation.data;

import java.sql.SQLException;
import enrollmentrenovation.business.Course;

public interface CourseModel extends EntityModel<Course> {
    public void addDiscipline(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) throws Exception;
    public void deleteDiscipline(int IdCourse, int IdDiscipline) throws Exception;
    public void delete(String name) throws Exception;
    public void update(int id, String name, int idSchool) throws Exception;
}
