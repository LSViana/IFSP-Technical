package enrollmentrenovation.service;

import enrollmentrenovation.business.Course;
import enrollmentrenovation.data.CourseDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseService implements CourseFunctional {
    
    private CourseDAO dao;
    
    public CourseService() {
        dao = new CourseDAO();
    }
    
    @Override
    public Course register(int Id, String Name, int IdSchool) throws ClassNotFoundException, SQLException {
        Course result = new Course(Id, Name, IdSchool);
        try {
            dao.insert(result);
        } catch (Exception ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Course> searchAll() throws SQLException, ClassNotFoundException {
        try {
            return dao.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Course> filter(String Name) throws SQLException, ClassNotFoundException {
        try {
            return dao.filter(Name);
        } catch (Exception ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(int Id, String Name, int IdSchool) throws ClassNotFoundException, SQLException {
        dao.update(Id, Name, IdSchool);
    }

    @Override
    public void delete(String Name) throws ClassNotFoundException, SQLException {
        dao.delete(Name);
    }

    @Override
    public void addDiscipline(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) throws SQLException {
        try {
            dao.addDiscipline(IdCourse, IdDiscipline, Semester, Facultative);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteDiscipline(int IdCourse, int IdDiscipline) throws SQLException {
        try {
            dao.deleteDiscipline(IdCourse, IdDiscipline);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}