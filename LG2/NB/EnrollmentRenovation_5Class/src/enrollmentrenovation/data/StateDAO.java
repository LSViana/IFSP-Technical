package enrollmentrenovation.data;

import enrollmentrenovation.business.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDAO implements EntityModel<State> {

    private java.sql.Connection connection;
    private String SQL_GETALL = "SELECT * FROM State;";
    private String SQL_GET = "SELECT * FROM State WHERE Name = ?;";
    private String SQL_GETINDEX = "SELECT * FROM State LIMIT ?,1;";
    private String SQL_FILTER = "SELECT * FROM State WHERE Name LIKE ?;";
    private String SQL_INSERT = "INSERT INTO State VALUES(?, ?, ?);";
    private String SQL_DELETE = "DELETE FROM State WHERE Name = ?;";
    private String SQL_UPDATE = "UPDATE State SET Name = ?, Initials = ? WHERE Id = ?;";

    @Override
    public List<State> getAll() throws Exception {
        connection = Connection.openConnection();
        List<State> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_GETALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new State(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public State get(int index) throws Exception {
        connection = Connection.openConnection();
        State result;
        PreparedStatement ps = connection.prepareStatement(SQL_GET);
        ResultSet rs = ps.executeQuery();
        try {
            return new State(rs.getInt(1), rs.getString(2), rs.getString(3));
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public State get(String filter) throws Exception {
        connection = Connection.openConnection();
        State result;
        PreparedStatement ps = connection.prepareStatement(SQL_GETINDEX);
        ResultSet rs = ps.executeQuery();
        try {
            rs.next();
            return new State(rs.getInt(1), rs.getString(2), rs.getString(3));
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public List<State> filter(String filter) throws Exception {
        connection = Connection.openConnection();
        List<State> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_FILTER);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new State(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public boolean insert(State object) throws Exception {
        try {
            connection = Connection.openConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, 0);
            ps.setString(2, object.getName());
            ps.setString(3, object.getInitials());
            ps.execute();
            Connection.closeConnection(connection);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public boolean insertRange(List<State> objects) throws Exception {
        try {
            connection = Connection.openConnection();
            for (State object : objects) {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
                ps.setInt(1, 0);
                ps.setString(2, object.getName());
                ps.setString(3, object.getInitials());
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
    public void delete(String name) throws ClassNotFoundException, SQLException {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }
    
    public void update(int id, String name, String initials) throws ClassNotFoundException, SQLException {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
        ps.setString(1, name);
        ps.setString(2, initials);
        ps.setInt(3, id);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }
}
