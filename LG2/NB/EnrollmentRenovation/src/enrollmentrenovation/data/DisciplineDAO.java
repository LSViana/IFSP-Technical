package enrollmentrenovation.data;

import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Restriction;
import enrollmentrenovation.business.SchoolClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDAO implements DisciplineModel {

    @Override
    public Discipline get(int Id) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Discipline WHERE Id = ?;";
            Discipline result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Discipline(rs.getInt(1), rs.getString(2), null, null, null, null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Discipline get(String Name) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Discipline WHERE Name = ?;";
            Discipline result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Discipline(rs.getInt(1), rs.getString(2), null, null, null, null, null);
            } else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<SchoolClass> getSchoolClasses(Discipline discipline) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Class WHERE IdDiscipline = ?;";
            List<SchoolClass> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, discipline.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new SchoolClass(rs.getInt(1), rs.getShort(2), null, null, null, rs.getObject(6, LocalDate.class), rs.getObject(7, LocalDate.class), null));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<CourseStructure> getStructures(Discipline discipline) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM CourseStructure WHERE IdDiscipline = ?;";
            List<CourseStructure> result = new ArrayList<>();
            // Relationships DAO
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, discipline.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new CourseStructure(courseDAO.get(rs.getInt(1)), get(rs.getInt(2)), rs.getInt(3), rs.getBoolean(4)));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Credits> getCredits(Discipline discipline) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Credits WHERE IdDiscipline = ?;";
            List<Credits> result = new ArrayList<>();
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, discipline.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new Credits(rs.getObject(4, LocalDate.class), userDAO.get(rs.getInt(1)), get(rs.getInt(2)), courseDAO.get(rs.getInt(3))));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Restriction> getRequirements(Discipline discipline) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Restriction WHERE IdProvided = ?;";
            List<Restriction> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, discipline.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new Restriction(get(rs.getInt(1)), discipline));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Restriction> getAchievements(Discipline discipline) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Restriction WHERE IdRequired = ?;";
            List<Restriction> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, discipline.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new Restriction(get(rs.getInt(1)), discipline));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public List<Discipline> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Discipline;";
            List<Discipline> result = new ArrayList<>();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(new Discipline(rs.getInt(1), rs.getString(2), null, null, null, null, null));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Discipline insert(Discipline object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO Discipline VALUES(?, ?);";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.setString(2, object.getName());
            stmt.executeUpdate();
            correctIdentity(conn, object);
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<Discipline> objects) throws Exception {
        for(Discipline object : objects)
            insert(object);
    }

    @Override
    public boolean exists(Discipline object) throws Exception {
        return get(object.getId()) != null;
    }

    @Override
    public void delete(Discipline object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM Discipline WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(Discipline object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE Discipline SET Name = ? WHERE Id = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getName());
            stmt.setInt(2, object.getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    private void correctIdentity(Connection conn, Discipline object) throws SQLException {
        String sql = "SELECT * FROM Discipline WHERE Id IN (SELECT MAX(Id) FROM Discipline WHERE Name = ?);";
        // SQL Query Execution
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        object.setId(rs.getInt(1));
    }

}
