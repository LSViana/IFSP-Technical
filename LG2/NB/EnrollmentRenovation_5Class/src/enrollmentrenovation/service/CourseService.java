package enrollmentrenovation.service;

import enrollmentrenovation.business.Course;
import enrollmentrenovation.data.CourseDAO;
import java.util.List;

public class CourseService implements CourseFunctional {

    private CourseDAO dao;

    public CourseService() {
        dao = new CourseDAO();
    }

    @Override
    public Course register(int Id, String Name, int IdSchool) throws Exception {
        Course result = new Course(Id, Name, IdSchool);
        result.setId(dao.get(result.getName()).getId());
        return result;
    }

    @Override
    public List<Course> searchAll() throws Exception {
        return dao.getAll();
    }

    @Override
    public List<Course> filter(String Name) throws Exception {
        return dao.filter(Name);
    }

    @Override
    public void update(int Id, String Name, int IdSchool) throws Exception {
        dao.update(Id, Name, IdSchool);
    }

    @Override
    public void delete(String Name) throws Exception {
        dao.delete(Name);
    }

    @Override
    public void addDiscipline(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) throws Exception {
        dao.addDiscipline(IdCourse, IdDiscipline, Semester, Facultative);
    }

    @Override
    public void deleteDiscipline(int IdCourse, int IdDiscipline) throws Exception {
        dao.deleteDiscipline(IdCourse, IdDiscipline);
    }
}
