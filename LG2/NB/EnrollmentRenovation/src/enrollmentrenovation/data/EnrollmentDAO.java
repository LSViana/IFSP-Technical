package enrollmentrenovation.data;

import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.SchoolClass;
import enrollmentrenovation.business.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO implements EnrollmentModel {

    @Override
    public Enrollment get(User Student, SchoolClass SchoolClass, Course Course) throws Exception {
        return get(Student.getId(), SchoolClass.getId(), Course.getId());
    }
    
    @Override
    public Enrollment get(int IdStudent, int IdSchoolClass, int IdCourse) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Enrollment WHERE IdUser = ? AND IdClass = ? AND IdCourse = ?;";
            Enrollment result = null;
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            SchoolClassDAO schoolClassDAO = new SchoolClassDAO();
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, IdStudent);
            stmt.setInt(2, IdSchoolClass);
            stmt.setInt(3, IdCourse);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Enrollment(userDAO.get(rs.getInt(1)), schoolClassDAO.get(rs.getInt(2)), courseDAO.get(rs.getInt(3)), rs.getShort(4), rs.getShort(5), rs.getFloat(6));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public User getUser(Enrollment enrollment) throws Exception {
        return enrollment.getStudent();
    }

    @Override
    public SchoolClass getSchoolClass(Enrollment enrollment) throws Exception {
        return enrollment.getSchoolClass();
    }

    @Override
    public Course getCourse(Enrollment enrollment) throws Exception {
        return enrollment.getCourse();
    }

    @Override
    public List<Enrollment> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Enrollment;";
            List<Enrollment> result = new ArrayList<>();
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            SchoolClassDAO schoolClassDAO = new SchoolClassDAO();
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(new Enrollment(userDAO.get(rs.getInt(1)), schoolClassDAO.get(rs.getInt(2)), courseDAO.get(rs.getInt(3)), rs.getShort(4), rs.getShort(5), rs.getFloat(6)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Enrollment insert(Enrollment object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO Enrollment VALUES(?, ?, ?, ?, ?, ?);";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getStudent().getId());
            stmt.setInt(2, object.getSchoolClass().getId());
            stmt.setInt(3, object.getCourse().getId());
            stmt.setInt(4, object.getSemester());
            stmt.setShort(5, object.getStatus());
            stmt.setFloat(6, object.getGrade());
            stmt.executeUpdate();
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<Enrollment> objects) throws Exception {
        for (Enrollment object : objects) {
            insert(object);
        }
    }

    @Override
    public boolean exists(Enrollment object) throws Exception {
        return get(object.getStudent(), object.getSchoolClass(), object.getCourse()) != null;
    }

    @Override
    public void delete(Enrollment object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM Enrollment WHERE IdUser = ?, IdClass = ? AND IdCourse = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getStudent().getId());
            stmt.setInt(2, object.getSchoolClass().getId());
            stmt.setInt(3, object.getCourse().getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(Enrollment object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE Enrollment SET Semester = ?, Status = ?, Grade = ? WHERE IdUser = ?, IdClass = ? AND IdCourse = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getSemester());
            stmt.setInt(2, object.getStatus());
            stmt.setFloat(3, object.getGrade());
            stmt.setInt(4, object.getStudent().getId());
            stmt.setInt(5, object.getSchoolClass().getId());
            stmt.setInt(6, object.getCourse().getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

}
