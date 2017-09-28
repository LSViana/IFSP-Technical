package enrollmentrenovation.data;

import enrollmentrenovation.business.City;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements EntityModel<City> {

    private java.sql.Connection connection;
    private String SQL_GETALL = "SELECT * FROM City;";
    private String SQL_GET = "SELECT * FROM City WHERE Name = ?;";
    private String SQL_GETINDEX = "SELECT * FROM City LIMIT ?,1;";
    private String SQL_FILTER = "SELECT * FROM City WHERE Name LIKE ?;";
    private String SQL_INSERT = "INSERT INTO City VALUES(?, ?, ?);";
    private String SQL_DELETE = "DELETE FROM State WHERE Name = ?;";
    private String SQL_UPDATE = "UPDATE City SET Name = ?, IdState = ? WHERE Id = ?;";

    @Override
    public List<City> getAll() throws Exception {
        connection = Connection.openConnection();
        List<City> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_GETALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new City(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public City get(int index) throws Exception {
        connection = Connection.openConnection();
        City result;
        PreparedStatement ps = connection.prepareStatement(SQL_GET);
        ResultSet rs = ps.executeQuery();
        try {
            return new City(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public City get(String filter) throws Exception {
        connection = Connection.openConnection();
        City result;
        PreparedStatement ps = connection.prepareStatement(SQL_GETINDEX);
        ResultSet rs = ps.executeQuery();
        try {
            rs.next();
            return new City(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch (Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public List<City> filter(String filter) throws Exception {
        connection = Connection.openConnection();
        List<City> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_FILTER);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new City(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public boolean insert(City object) throws Exception {
        try {
            connection = Connection.openConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, 0);
            ps.setString(2, object.getName());
            ps.setInt(3, object.getIdState());
            ps.execute();
            Connection.closeConnection(connection);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public boolean insertRange(List<City> objects) throws Exception {
        try {
            connection = Connection.openConnection();
            for (City object : objects) {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
                ps.setInt(1, 0);
                ps.setString(2, object.getName());
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

    public void delete(String name) throws ClassNotFoundException, SQLException {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }

    public void update(int id, String name, int idState) throws ClassNotFoundException, SQLException {
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
        ps.setString(1, name);
        ps.setInt(2, idState);
        ps.setInt(1, id);
        ps.executeUpdate();
        Connection.closeConnection(connection);
    }
}
