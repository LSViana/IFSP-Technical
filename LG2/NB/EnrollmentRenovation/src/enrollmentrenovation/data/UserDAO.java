package enrollmentrenovation.data;

import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.State;
import enrollmentrenovation.business.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserModel {

    @Override
    public User get(int Id) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM User WHERE Id = ?;";
            User result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getString(5), rs.getInt(7), null, null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public User get(String Username, String Password) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM User WHERE Id = ? AND Password = ?;";
            User result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(Username));
            stmt.setString(2, Password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getString(5), rs.getInt(7), null, null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public State getState(User user) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM State WHERE Id IN (SELECT IdState FROM User WHERE Id = ?);";
            State result = null;
            // Relationships DAO
            StateDAO stateDAO = new StateDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = stateDAO.get(rs.getInt(1));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Credits> getCredits(User user) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Credits WHERE IdStudent = ?;";
            List<Credits> result = new ArrayList<>();
            // Relationships DAO
            CreditsDAO creditsDAO = new CreditsDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(creditsDAO.get(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Enrollment> getEnrollments(User user) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Enrollment WHERE IdStudent = ?;";
            List<Enrollment> result = new ArrayList<>();
            // Relationships DAO
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(enrollmentDAO.get(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<User> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM User;";
            List<User> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getObject(4, LocalDate.class), rs.getString(5), rs.getInt(7), null, null, null));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public User insert(User object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO User VALUES(0, ?, ?, ?, ?, ?, ?)";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getFirstName());
            stmt.setString(2, object.getLastName());
            stmt.setObject(3, object.getBirthday());
            stmt.setString(4, object.getPassword());
            stmt.setInt(5, object.getState().getId());
            stmt.setInt(6, object.getType());
            stmt.executeUpdate();
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<User> objects) throws Exception {
        for(User object : objects)
            insert(object);
    }

    @Override
    public boolean exists(User object) throws Exception {
        return get(object.getId()) != null;
    }

    @Override
    public void delete(User object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM User WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(User object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE User SET FirstName = ?, LastName = ?, Birthday = ?, Password = ?, IdState = ?, Type = ? WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(7, object.getId());
            //
            stmt.setString(1, object.getFirstName());
            stmt.setString(2, object.getLastName());
            stmt.setObject(3, object.getBirthday());
            stmt.setString(4, object.getPassword());
            stmt.setInt(5, object.getState().getId());
            stmt.setInt(6, object.getType());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
    
    private void correctIdentity(Connection conn, User object) throws Exception {
        String sql = "SELECT * FROM User WHERE Id IN (SELECT MAX(Id) FROM User WHERE FirstName = ? AND LastName = ?);";
        // SQL Query Execution
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, object.getFirstName());
        stmt.setString(2, object.getLastName());
        ResultSet rs = stmt.executeQuery();
        rs.next();
        object.setId(rs.getInt(1));
    }
    
}