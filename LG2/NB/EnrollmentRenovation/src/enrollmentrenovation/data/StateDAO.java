package enrollmentrenovation.data;

import enrollmentrenovation.business.School;
import enrollmentrenovation.business.SchoolClass;
import enrollmentrenovation.business.State;
import enrollmentrenovation.business.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StateDAO implements StateModel {

    @Override
    public State get(int Id) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM State WHERE Id = ?;";
            State result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new State(rs.getInt(1), rs.getString(2), rs.getString(3), null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public State get(String Name) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM State WHERE Name = ?;";
            State result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new State(rs.getInt(1), rs.getString(2), rs.getString(3), null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<School> getSchools(State state) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM School WHERE IdState = ?;";
            List<School> result = new ArrayList<>();
            // Relationships DAO
            SchoolDAO schoolDAO = new SchoolDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, state.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(schoolDAO.get(rs.getInt(1)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<User> getUsers(State state) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM User WHERE IdState = ?;";
            List<User> result = new ArrayList<>();
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, state.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(userDAO.get(rs.getInt(1)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<State> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM State;";
            List<State> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result.add(new State(rs.getInt(1), rs.getString(2), rs.getString(3), null, null));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public State insert(State object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO State VALUES(0, ?, ?);";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getName());
            stmt.setString(2, object.getInitials());
            stmt.executeUpdate();
            correctIdentity(conn, object);
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<State> objects) throws Exception {
        for(State object : objects)
            insert(object);
    }

    @Override
    public boolean exists(State object) throws Exception {
        return get(object.getId()) != null;
    }

    @Override
    public void delete(State object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM State WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(State object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE State SET Name = ?, Initials = ? WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(3, object.getId());
            //
            stmt.setString(2, object.getName());
            stmt.setString(3, object.getInitials());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
    
    private void correctIdentity(Connection conn, State object) throws Exception {
        String sql = "SELECT * FROM State WHERE Id IN (SELECT MAX(Id) FROM State WHERE Name = ?);";
        // SQL Query Execution
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, object.getName());
        ResultSet rs = stmt.executeQuery();
        rs.next();
        object.setId(rs.getInt(1));
    }
    
}
