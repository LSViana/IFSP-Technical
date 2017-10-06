package enrollmentrenovation.data;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class CreditsDAO implements CreditsModel {

    @Override
    public Credits get(User Student, Discipline Discipline, Course Course) throws Exception {
        return get(Student.getId(), Discipline.getId(), Course.getId());
    }

    @Override
    public Credits get(int IdStudent, int IdDiscipline, int IdCourse) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Credits WHERE IdUser = ? AND IdDiscipline = ? AND IdCourse = ?;";
            Credits result = null;
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, IdStudent);
            stmt.setInt(2, IdDiscipline);
            stmt.setInt(3, IdCourse);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                result = new Credits(rs.getObject(4, LocalDate.class), userDAO.get(IdStudent), disciplineDAO.get(IdDiscipline), courseDAO.get(IdCourse));
            }
            else {
                return null;
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public User getUser(Credits credits) throws Exception {
        return credits.getStudent();
    }

    @Override
    public Discipline getDiscipline(Credits credits) throws Exception {
        return credits.getDiscipline();
    }

    @Override
    public Course getCourse(Credits credits) throws Exception {
        return credits.getCourse();
    }

    @Override
    public List<Credits> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM Credits;";
            List<Credits> result = new ArrayList<Credits>();
            // Relationships DAO
            UserDAO userDAO = new UserDAO();
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            CourseDAO courseDAO = new CourseDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(new Credits(rs.getObject(4, LocalDate.class), userDAO.get(rs.getInt(1)), disciplineDAO.get(rs.getInt(2)), courseDAO.get(rs.getInt(3))));
            }
            return result;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Credits insert(Credits object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO Credits VALUES(?, ?, ?, ?);";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getStudent().getId());
            stmt.setInt(2, object.getDiscipline().getId());
            stmt.setInt(3, object.getCourse().getId());
            stmt.setObject(4, object.getDateRequirement());
            stmt.executeUpdate();
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<Credits> objects) throws Exception {
        for(Credits object : objects)
            insert(object);
    }

    @Override
    public boolean exists(Credits object) throws Exception {
        return get(object.getStudent(), object.getDiscipline(), object.getCourse()) != null;
    }

    @Override
    public void delete(Credits object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM Credits WHERE IdStudent = ? AND IdDiscipline = ? AND IdCourse = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getStudent().getId());
            stmt.setInt(2, object.getDiscipline().getId());
            stmt.setInt(3, object.getCourse().getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(Credits object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE Credits SET DateRequirement = ? WHERE IdStudent = ? AND IdDiscipline = ? AND IdCourse = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, object.getDateRequirement());
            stmt.setInt(2, object.getStudent().getId());
            stmt.setInt(3, object.getDiscipline().getId());
            stmt.setInt(4, object.getCourse().getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
    
}
