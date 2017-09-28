package enrollmentrenovation.data;

import java.sql.SQLException;

public interface CourseModel {
    public void addDiscipline(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) throws SQLException, ClassNotFoundException;
    public void deleteDiscipline(int IdCourse, int IdDiscipline) throws SQLException, ClassNotFoundException;
    public void delete(String name) throws ClassNotFoundException, SQLException;
    public void update(int id, String name, int idSchool) throws ClassNotFoundException, SQLException;
}
