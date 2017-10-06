package enrollmentrenovation.data;

import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.SchoolClass;
import enrollmentrenovation.business.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SchoolClassDAO implements SchoolClassModel {

    @Override
    public SchoolClass get(int Id) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Class WHERE Id = ?;";
            SchoolClass result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new SchoolClass(rs.getInt(1), rs.getShort(2), null, null, null, rs.getObject(6, LocalDate.class), rs.getObject(7, LocalDate.class), null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Discipline getDiscipline(SchoolClass schoolClass) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Disciplne WHERE Id IN (SELECT IdDiscipline FROM Class WHERE Id = ?);";
            Discipline result = null;
            // Relationships DAO
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schoolClass.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = disciplineDAO.get(rs.getInt(1));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Time getInitialTime(SchoolClass schoolClass) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Time WHERE Id IN (SELECT IdInitialTime FROM Class WHERE Id = ?);";
            Time result = null;
            // Relationships DAO
            TimeDAO timeDAO = new TimeDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schoolClass.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = timeDAO.get(rs.getInt(1));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Time getFinalTime(SchoolClass schoolClass) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Time WHERE Id IN (SELECT IdFinalTime FROM Class WHERE Id = ?);";
            Time result = null;
            // Relationships DAO
            TimeDAO timeDAO = new TimeDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schoolClass.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = timeDAO.get(rs.getInt(1));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public LocalDate getInitialDate(SchoolClass schoolClass) throws Exception {
        return schoolClass.getInitialDate();
    }

    @Override
    public LocalDate getFinalDate(SchoolClass schoolClass) throws Exception {
        return schoolClass.getFinalDate();
    }

    @Override
    public List<Enrollment> getEnrollments(SchoolClass schoolClass) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Enrollment WHERE IdClass = ?;";
            List<Enrollment> result = new ArrayList<>();
            // Relationships DAO
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
            UserDAO userDAO = new UserDAO();
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schoolClass.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(enrollmentDAO.get(userDAO.get(rs.getInt(1)), schoolClass, courseDAO.get(rs.getInt(3))));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<SchoolClass> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Class;";
            List<SchoolClass> result = new ArrayList<>();
            // SQL Query Executiona
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new SchoolClass(rs.getInt(1), rs.getShort(2), null, null, null, rs.getObject(6, LocalDate.class), rs.getObject(7, LocalDate.class), null));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public SchoolClass insert(SchoolClass object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO Class VALUES(0, ?, ?, ?, ?, ?, ?);";
            // SQL Query Executiona
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getDiscipline().getId());
            stmt.setInt(2, object.getDay());
            stmt.setInt(3, object.getInitialTime().getId());
            stmt.setInt(4, object.getFinalTime().getId());
            stmt.setObject(5, object.getInitialDate());
            stmt.setObject(6, object.getFinalDate());
            stmt.executeUpdate();
            correctIdentity(conn, object);
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<SchoolClass> objects) throws Exception {
        for(SchoolClass object : objects)
            insert(object);
    }

    @Override
    public boolean exists(SchoolClass object) throws Exception {
        return get(object.getId()) != null;
    }

    @Override
    public void delete(SchoolClass object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM Class WHERE Id = ?;";
            // SQL Query Executiona
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(SchoolClass object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE Class SET IdDiscipline = ?, Day = ?, IdInitialTime = ?, IdFinalTime = ?, InitialDate = ?, EndDate = ? WHERE Id = ?;";
            // SQL Query Executiona
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(7, object.getDiscipline().getId());
            //
            stmt.setInt(1, object.getDiscipline().getId());
            stmt.setShort(2, object.getDay());
            stmt.setInt(3, object.getInitialTime().getId());
            stmt.setInt(4, object.getFinalTime().getId());
            stmt.setObject(5, object.getInitialDate());
            stmt.setObject(6, object.getFinalDate());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
    
     private void correctIdentity(Connection conn, SchoolClass object) throws Exception {
        String sql = "SELECT * FROM Enrollment WHERE Id IN (SELECT MAX(Id) FROM Enrollment);";
        // SQL Query Execution
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        object.setId(rs.getInt(1));
    }

}
