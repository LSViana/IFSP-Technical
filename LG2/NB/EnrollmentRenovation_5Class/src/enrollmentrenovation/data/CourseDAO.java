package enrollmentrenovation.data;
import enrollmentrenovation.business.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements EntityModel<Course> {

    private java.sql.Connection connection;
    private String SQL_GETALL = "SELECT * FROM Course;";
    private String SQL_GET = "SELECT * FROM Course WHERE Name = ?;";
    private String SQL_GETINDEX = "SELECT * FROM Course LIMIT ?,1;";
    private String SQL_FILTER = "SELECT * FROM Course WHERE Name LIKE ?;";
    private String SQL_INSERT = "INSERT INTO Course VALUES(?, ?, ?);";
    
    @Override
    public List<Course> getAll() throws Exception {
        connection = Connection.openConnection();
        List<Course> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_GETALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Course(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public Course get(int index) throws Exception {
        connection = Connection.openConnection();
        Course result;
        PreparedStatement ps = connection.prepareStatement(SQL_GET);
        ResultSet rs = ps.executeQuery();
        try {
            return new Course(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch(Exception exc) {
            return null;
        } finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public Course get(String filter) throws Exception {
        connection = Connection.openConnection();
        Course result;
        PreparedStatement ps = connection.prepareStatement(SQL_GETINDEX);
        ResultSet rs = ps.executeQuery();
        try {
            rs.next();
            return new Course(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch(Exception exc) {
            return null;
        }
        finally {
            Connection.closeConnection(connection);
        }
    }

    @Override
    public List<Course> filter(String filter) throws Exception {
        connection = Connection.openConnection();
        List<Course> result = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SQL_FILTER);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result.add(new Course(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        Connection.closeConnection(connection);
        return result;
    }

    @Override
    public boolean insert(Course object) throws Exception {
        try {
            connection = Connection.openConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, 0);
            ps.setString(2, object.getName());
            ps.setInt(3, object.getIdSchool());
            ps.execute();
            Connection.closeConnection(connection);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public boolean insertRange(List<Course> objects) throws Exception {
        try {
            connection = Connection.openConnection();
            for (Course object : objects) {                
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
                ps.setInt(1, 0);
                ps.setString(2, object.getName());
                ps.setInt(3, object.getIdSchool());
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