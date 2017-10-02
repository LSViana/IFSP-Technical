package enrollmentrenovation.data;
import enrollmentrenovation.business.Discipline;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDAO implements EntityModel<Discipline> {

    private java.sql.Connection connection;
    private String SQL_GETALL = "SELECT * FROM Discipline;";
    private String SQL_GET = "SELECT * FROM Discipline WHERE Name = ?;";
    private String SQL_GETINDEX = "SELECT * FROM Discipline LIMIT ?,1;";
    private String SQL_FILTER = "SELECT * FROM Discipline WHERE Name LIKE ?;";
    private String SQL_INSERT = "INSERT INTO Discipline VALUES(?, ?);";

    @Override
    public List<Discipline> getAll() throws Exception {
        connection = Connection.openConnection();
        List<Discipline> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_GETALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Discipline(rs.getInt(1), rs.getString(2)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public Discipline get(int index) throws Exception {
        connection = Connection.openConnection();
        Discipline result;
        PreparedStatement ps = connection.prepareStatement(SQL_GET);
        ResultSet rs = ps.executeQuery();
        try {
            return new Discipline(rs.getInt(1), rs.getString(2));
        } catch(Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public Discipline get(String filter) throws Exception {
        connection = Connection.openConnection();
        Discipline result;
        PreparedStatement ps = connection.prepareStatement(SQL_GETINDEX);
        ResultSet rs = ps.executeQuery();
        try {
            rs.next();
            return new Discipline(rs.getInt(1), rs.getString(2));
        } catch(Exception exc) {
            return null;
        }
        finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public List<Discipline> filter(String filter) throws Exception {
        connection = Connection.openConnection();
        List<Discipline> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_FILTER);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Discipline(rs.getInt(1), rs.getString(2)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public boolean insert(Discipline object) throws Exception {
        try {
            connection = Connection.openConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, 0);
            ps.setString(2, object.getName());
            ps.execute();
            Connection.closeConnection(connection);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public boolean insertRange(List<Discipline> objects) throws Exception {
        try {
            connection = Connection.openConnection();
            for (Discipline object : objects) {                
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
        if(get(filter) != null)
            return true;
        return false; 
    }    
}