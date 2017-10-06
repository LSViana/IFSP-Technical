package enrollmentrenovation.data;

import enrollmentrenovation.business.School;
import enrollmentrenovation.business.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO implements TimeModel {

    @Override
    public Time get(int Id) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Time WHERE Id = ?;";
            Time result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Time(rs.getInt(1), rs.getObject(2, LocalTime.class));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Time get(LocalTime Time) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Time WHERE Time = ?;";
            Time result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, Time);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Time(rs.getInt(1), rs.getObject(2, LocalTime.class));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Time> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Time;";
            List<Time> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result.add(new Time(rs.getInt(1), rs.getObject(2, LocalTime.class)));
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Time insert(Time object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO Time VALUES(0, ?);";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, object.getTime());
            stmt.executeUpdate();
            correctIdentity(conn, object);
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<Time> objects) throws Exception {
        for(Time object : objects)
            insert(object);
    }

    @Override
    public boolean exists(Time object) throws Exception {
        return get(object.getId()) != null;
    }

    @Override
    public void delete(Time object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM Time WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(Time object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE Time SET Time = ? WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(2, object.getId());
            //
            stmt.setObject(1, object.getTime());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
    
    private void correctIdentity(Connection conn, Time object) throws Exception {
        String sql = "SELECT * FROM State WHERE Id IN (SELECT MAX(Id) FROM State);";
        // SQL Query Execution
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        object.setId(rs.getInt(1));
    }
    
}
