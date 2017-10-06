package enrollmentrenovation.data;

import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.School;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CourseDAO implements CourseModel {

    @Override
    public Course get(int Id) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Course WHERE Id = ?;";
            Course result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Course(rs.getInt(1), rs.getString(2), null, null, null, null);
                return result;
            } else {
                return null;
            }
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Course get(String Name) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Course WHERE Name = ?;";
            Course result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Course(rs.getInt(1), rs.getString(2), null, null, null, null);
                return result;
            } else {
                return null;
            }
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public School getSchool(Course course) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT IdSchool FROM Course WHERE Id = ?;";
            School result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, course.getId());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int IdSchool = rs.getInt(1);
            SchoolDAO schoolDAO = new SchoolDAO();
            result = schoolDAO.get(IdSchool);
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Credits> getCredits(Course course) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Credits WHERE IdCourse = ?;";
            List<Credits> result = new ArrayList<>();
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, course.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(new Credits(rs.getObject(4, LocalDate.class), userDAO.get(rs.getInt(1)), disciplineDAO.get(rs.getInt(2)), course));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<CourseStructure> getStructures(Course course) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM CourseStructure WHERE IdCourse = ?;";
            List<CourseStructure> result = new ArrayList<>();
            // Relationships DAO
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, course.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(new CourseStructure(course, disciplineDAO.get(rs.getInt(2)), rs.getInt(3), rs.getBoolean(4)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Enrollment> getEnrollments(Course course) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Enrollment WHERE IdCourse = ?;";
            List<Enrollment> result = new ArrayList<>();
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            SchoolClassDAO schoolClassDAO = new SchoolClassDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, course.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(new Enrollment(userDAO.get(rs.getInt(1)), schoolClassDAO.get(rs.getInt(2)), course, rs.getShort(4), rs.getShort(5), rs.getFloat(6)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertStructure(Course course, CourseStructure courseStructure) throws Exception {
        CourseStructureDAO courseStructureDAO = new CourseStructureDAO();
        course.getStructure().add(courseStructureDAO.insert(courseStructure));
    }

    @Override
    public void deleteStructure(Course course, CourseStructure courseStructure) throws Exception {
        CourseStructureDAO courseStructureDAO = new CourseStructureDAO();
        courseStructureDAO.delete(courseStructure);
        course.getStructure().remove(courseStructure);
    }

    @Override
    public CourseStructure containsDiscipline(Course course, Discipline discipline) throws Exception {
        CourseStructureDAO courseStructureDAO = new CourseStructureDAO();
        return courseStructureDAO.get(course, discipline);
    }

    @Override
    public List<Course> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Course;";
            List<Course> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result.add(new Course(rs.getInt(1), rs.getString(2), null, null, null, null));
                return result;
            } else {
                return null;
            }
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Course insert(Course object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO Course VALUES(0, ?, ?)";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getName());
            stmt.setInt(2, object.getSchool().getId());
            stmt.executeUpdate();
            correctIdentity(conn, object);
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<Course> objects) throws Exception {
        for(Course object : objects) {
            insert(object);
        }
    }

    @Override
    public boolean exists(Course object) throws Exception {
        return get(object.getId()) != null ? true : false;
    }

    @Override
    public void delete(Course object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM Course WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(Course object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE FROM Course SET Name = ?, IdSchool = ? WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getName());
            stmt.setInt(2, object.getSchool().getId());
            stmt.setInt(3, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    private void correctIdentity(Connection conn, Course object) throws Exception {
        String sql = "SELECT * FROM Course WHERE Id IN (SELECT MAX(Id) FROM Course WHERE Name = ?);";
        // SQL Query Execution
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, object.getName());
        ResultSet rs = stmt.executeQuery();
        rs.next();
        object.setId(rs.getInt(1));
    }

}
