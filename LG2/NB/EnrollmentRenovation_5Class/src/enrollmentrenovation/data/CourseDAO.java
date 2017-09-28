package enrollmentrenovation.data;

import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.Discipline;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements CourseModel {

    private java.sql.Connection connection;
    private String SQL_GETALL = "SELECT * FROM Course;";
    private String SQL_GET = "SELECT * FROM Course WHERE Name = ?;";
    private String SQL_GETINDEX = "SELECT * FROM Course LIMIT ?,1;";
    private String SQL_FILTER = "SELECT * FROM Course WHERE Name LIKE ?;";
    private String SQL_INSERT = "INSERT INTO Course VALUES(?, ?, ?);";
    private String SQL_ADDDISCIPLINE = "INSERT INTO CourseStructure VALUES(?, ?, ?, ?)";
    private String SQL_DELETEDISCIPLINE = "DELETE FROM CourseStructure WHERE IdCourse = ? AND IdDiscipline = ?;";
    private String SQL_GETDISCIPLINES = "SELECT * FROM Discipline JOIN (SELECT * FROM CourseStructure WHERE IdCourse = ?) AS Structure ON Discipline.Id = Structure.IdDiscipline;";
    private String SQL_DELETE = "DELETE FROM Course WHERE Name = ?;";
    private String SQL_UPDATE = "UPDATE Course SET Name = ?, IdSchool = ? WHERE Id = ?;";

    @Override
    public List<Course> getAll() throws Exception {
        connection = Connection.openConnection();
        List<Course> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_GETALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Course(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public Course get(int index) throws Exception {
        connection = Connection.openConnection();
        Course result;
        PreparedStatement ps = connection.prepareStatement(SQL_GET);
        ResultSet rsCourse = ps.executeQuery();
        try {
            result = new Course(rsCourse.getInt(1), rsCourse.getString(2), rsCourse.getInt(3));
            ps = connection.prepareStatement(SQL_GETDISCIPLINES);
            ps.setInt(1, result.getId());
            ResultSet rsDisciplines = ps.executeQuery();
            while (rsDisciplines.next()) {
                Discipline disc = new Discipline(rsDisciplines.getInt(1), rsDisciplines.getString(2));
                result.addDiscipline(disc, rsDisciplines.getInt(5), rsDisciplines.getBoolean(6));
            }
            return result;
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public Course get(String filter) throws Exception {
        connection = Connection.openConnection();
        Course result;
        PreparedStatement ps = connection.prepareStatement(SQL_GETINDEX);
        ResultSet rsCourse = ps.executeQuery();
        try {
            result = new Course(rsCourse.getInt(1), rsCourse.getString(2), rsCourse.getInt(3));
            ps = connection.prepareStatement(SQL_GETDISCIPLINES);
            ps.setInt(1, result.getId());
            ResultSet rsDisciplines = ps.executeQuery();
            while (rsDisciplines.next()) {
                Discipline disc = new Discipline(rsDisciplines.getInt(1), rsDisciplines.getString(2));
                result.addDiscipline(disc, rsDisciplines.getInt(5), rsDisciplines.getBoolean(6));
            }
            return result;
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public List<Course> filter(String filter) throws Exception {
        connection = Connection.openConnection();
        List<Course> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_FILTER);
        ResultSet rsCourses = ps.executeQuery();
        while (rsCourses.next()) {
            Course course = new Course(rsCourses.getInt(1), rsCourses.getString(2), rsCourses.getInt(3));
            ps = connection.prepareStatement(SQL_GETDISCIPLINES);
            ps.setInt(1, course.getId());
            ResultSet rsDisciplines = ps.executeQuery();
            while (rsDisciplines.next()) {
                Discipline disc = new Discipline(rsDisciplines.getInt(1), rsDisciplines.getString(2));
                course.addDiscipline(disc, rsDisciplines.getInt(5), rsDisciplines.getBoolean(6));
            }
            result.add(course);
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public boolean insert(Course object) throws Exception {
        try {
            connection = Connection.openConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, 0);
            ps.setString(2, object.getName());
            ps.setInt(3, object.getIdSchool());
            ps.execute();
            Connection.closeConnection(connection);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public boolean insertRange(List<Course> objects) throws Exception {
        try {
            connection = Connection.openConnection();
            for (Course object : objects) {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
                ps.setInt(1, 0);
                ps.setString(2, object.getName());
                ps.setInt(3, object.getIdSchool());
                ps.execute();
            }
            Connection.closeConnection(connection);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public boolean exists(String filter) throws Exception {
        if (get(filter) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void addDiscipline(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) throws Exception {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_ADDDISCIPLINE);
        ps.setInt(1, IdCourse);
        ps.setInt(2, IdDiscipline);
        ps.setInt(3, Semester);
        ps.setBoolean(4, Facultative);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }
    
    @Override
    public void deleteDiscipline(int IdCourse, int IdDiscipline) throws Exception {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_DELETEDISCIPLINE);
        ps.setInt(1, IdCourse);
        ps.setInt(2, IdDiscipline);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }

    @Override
    public void delete(String name) throws Exception {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }

    @Override
    public void update(int id, String name, int idSchool) throws Exception {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
        ps.setString(1, name);
        ps.setInt(2, idSchool);
        ps.setInt(3, id);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }
}
