package enrollmentrenovation.data;

import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.School;
import enrollmentrenovation.business.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO implements SchoolModel {

    @Override
    public School get(int Id) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM School WHERE Id = ?;";
            School result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new School(rs.getInt(1), rs.getString(2), null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public School get(String Name) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM School WHERE Name = ?;";
            School result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new School(rs.getInt(1), rs.getString(2), null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Course> getCourses(School school) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Course WHERE IdSchool = ?;";
            List<Course> result = new ArrayList<>();
            // Relationships DAO
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, school.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(courseDAO.get(rs.getInt(1)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public State getState(School school) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM State WHERE Id = ?;";
            State result = null;
            // Relationships DAO
            StateDAO stateDAO = new StateDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, school.getState().getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = stateDAO.get(rs.getInt(1));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<School> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM School;";
            List<School> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new School(rs.getInt(1), rs.getString(2), null, null));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public School insert(School object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO School VALUES(0, ?, ?);";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getName());
            stmt.setInt(2, object.getState().getId());
            stmt.executeUpdate();
            correctIdentity(conn, object);
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<School> objects) throws Exception {
        for(School object : objects)
            insert(object);
    }

    @Override
    public boolean exists(School object) throws Exception {
        return get(object.getId()) != null;
    }

    @Override
    public void delete(School object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM School WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(School object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE School SET Name = ?, IdState = ? WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(3, object.getId());
            //
            stmt.setString(1, object.getName());
            stmt.setInt(2, object.getState().getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
    
    private void correctIdentity(Connection conn, School object) throws Exception {
        String sql = "SELECT * FROM School WHERE Id IN (SELECT MAX(Id) FROM School WHERE Name = ?);";
        // SQL Query Execution
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, object.getName());
        ResultSet rs = stmt.executeQuery();
        rs.next();
        object.setId(rs.getInt(1));
    }
    
}
