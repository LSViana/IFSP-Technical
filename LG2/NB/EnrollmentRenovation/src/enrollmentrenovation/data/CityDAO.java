package enrollmentrenovation.data;

import enrollmentrenovation.business.City;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements CityModel {

    private java.sql.Connection connection;
    private String GETALL = "SELECT * FROM City;";
    private String GET = "SELECT * FROM City WHERE Id = ?;";
    private String GETNAME = "SELECT * FROM City WHERE Name = ?;";
    private String FILTER = "SELECT * FROM City WHERE Name LIKE ?;";
    private String INSERT = "INSERT INTO City VALUES(?, ?, ?);";
    private String DELETE = "DELETE FROM State WHERE Name = ?;";
    private String UPDATE = "UPDATE City SET Name = ?, IdState = ? WHERE Id = ?;";
    private String GETSTATE = "SELECT * FROM State WHERE Id = ?;";

    @Override
    public List<City> getAll() throws Exception {
        connection = Connection.openConnection();
        List<City> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(GETALL);
        ResultSet rsCity = ps.executeQuery();
        StateDAO stateDAO = new StateDAO();
        while (rsCity.next()) {
            int IdState = rsCity.getInt(3);
            result.add(new City(rsCity.getInt(1), rsCity.getString(2), stateDAO.get(IdState)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public City get(int Id) throws Exception {
        City result = null;
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(GET);
        ps.setInt(1, Id);
        ResultSet rs = ps.executeQuery();
        StateDAO stateDAO = new StateDAO();
        while(rs.next()) {
            int IdState = rs.getInt(3);
            result = new City(rs.getInt(1), rs.getString(2), stateDAO.get(IdState));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public City get(String Name) throws Exception {
        City result = null;
        connection = Connection.openConnection();
        PreparedStatement ps = connection.prepareStatement(GET);
        ps.setString(1, Name);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int IdState = rs.getInt(3);
            result = new City(rs.getInt(1), rs.getString(2));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public City insert(City object) throws Exception {
        
    }

    @Override
    public List<City> insertRange(List<City> objects) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(City object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(City object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(City object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
