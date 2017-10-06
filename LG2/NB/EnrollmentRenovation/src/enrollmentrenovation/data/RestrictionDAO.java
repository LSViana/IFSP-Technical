package enrollmentrenovation.data;

import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.Restriction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestrictionDAO implements RestrictionModel {

    @Override
    public Restriction get(Discipline Required, Discipline Provided) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Restriction WHERE IdRequired = ? AND IdProvided = ?;";
            Restriction result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Required.getId());
            stmt.setInt(2, Provided.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Restriction(Required, Provided);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Restriction> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Restriction;";
            List<Restriction> result = new ArrayList<>();
            // Relationships DAO
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(new Restriction(disciplineDAO.get(rs.getInt(1)), disciplineDAO.get(rs.getInt(2))));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Restriction insert(Restriction object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO Restriction VALUES(?, ?);";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getRequired().getId());
            stmt.setInt(2, object.getProvided().getId());
            stmt.executeUpdate();
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<Restriction> objects) throws Exception {
        for(Restriction object : objects)
            insert(object);
    }

    @Override
    public boolean exists(Restriction object) throws Exception {
        return get(object.getRequired(), object.getProvided()) != null;
    }

    @Override
    public void delete(Restriction object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM Restriction WHERE IdRequired = ? AND IdProvided = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getRequired().getId());
            stmt.setInt(2, object.getProvided().getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    /**
     * This method isn't allowed, since this object can't be edited
     * @param object This method isn't supposed to be used
     * @throws Exception An UnsupportedOperationException will be always thrown when this method is called
     */
    @Override
    public void update(Restriction object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
