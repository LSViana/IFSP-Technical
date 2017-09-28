package enrollmentrenovation.data;

import enrollmentrenovation.business.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO implements TimeModel {

    private java.sql.Connection connection;
    private String SQL_GETALL = "SELECT * FROM Time;";
    private String SQL_GET = "SELECT * FROM Time WHERE Time = ?;";
    private String SQL_GETINDEX = "SELECT * FROM Time LIMIT ?,1;";
    private String SQL_FILTER = "SELECT * FROM Time WHERE Time LIKE ?;";
    private String SQL_INSERT = "INSERT INTO Time VALUES(?, ?);";
    private String SQL_DELETE = "DELETE FROM Time WHERE Time = ?;";
    private String SQL_UPDATE = "UPDATE State SET Time = ? WHERE Id = ?;";

    @Override
    public List<Time> getAll() throws Exception {
        connection = Connection.openConnection();
        List<Time> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_GETALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Time(rs.getInt(1), rs.getObject(2, LocalTime.class)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public Time get(int index) throws Exception {
        connection = Connection.openConnection();
        Time result;
        PreparedStatement ps = connection.prepareStatement(SQL_GET);
        ResultSet rs = ps.executeQuery();
        try {
            return new Time(rs.getInt(1), rs.getObject(2, LocalTime.class));
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public Time get(String filter) throws Exception {
        connection = Connection.openConnection();
        Time result;
        PreparedStatement ps = connection.prepareStatement(SQL_GETINDEX);
        ResultSet rs = ps.executeQuery();
        try {
            rs.next();
            return new Time(rs.getInt(1), rs.getObject(2, LocalTime.class));
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public List<Time> filter(String filter) throws Exception {
        connection = Connection.openConnection();
        List<Time> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_FILTER);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Time(rs.getInt(1), rs.getObject(2, LocalTime.class)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public boolean insert(Time object) throws Exception {
        try {
            connection = Connection.openConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, 0);
            ps.setObject(2, object.getTime());
            ps.execute();
            Connection.closeConnection(connection);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public boolean insertRange(List<Time> objects) throws Exception {
        try {
            connection = Connection.openConnection();
            for (Time object : objects) {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
                ps.setInt(1, 0);
                ps.setObject(2, object.getTime());
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
    public void delete(String time) throws Exception {
        LocalTime lc = LocalTime.parse(time);
        delete(lc);
    }

    @Override
    public void delete(LocalTime time) throws Exception {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
        ps.setObject(1, time);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }
    
    @Override
    public void update(int id, LocalTime time) throws Exception {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
        ps.setObject(1, time);
        ps.setInt(2, id);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }
}
