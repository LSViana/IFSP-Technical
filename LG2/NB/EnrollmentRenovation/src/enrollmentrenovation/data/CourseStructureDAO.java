package enrollmentrenovation.data;

import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Discipline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseStructureDAO implements CourseStructureModel {

    @Override
    public CourseStructure get(Course course, Discipline discipline) throws Exception {
        return get(course.getId(), discipline.getId());
    }

    @Override
    public CourseStructure get(int IdCourse, int IdDiscipline) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM CourseStructure WHERE IdCourse = ? AND IdDiscipline = ?;";
            CourseStructure result = null;
            // Relationships DAO
            CourseDAO courseDAO = new CourseDAO();
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, IdCourse);
            stmt.setInt(2, IdDiscipline);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new CourseStructure(courseDAO.get(IdCourse), disciplineDAO.get(IdDiscipline), rs.getInt(3), rs.getBoolean(4));
                return result;
            } else {
                return null;
            }
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Course getCourse(CourseStructure courseStructure) throws Exception {
        return courseStructure.getCourse();
    }

    @Override
    public Discipline getDiscipline(CourseStructure courseStructure) throws Exception {
        return courseStructure.getDiscipline();
    }

    @Override
    public List<CourseStructure> getAll() throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "SELECT * FROM CourseStructure;";
            List<CourseStructure> result = new ArrayList<CourseStructure>();
            // Relationships DAO
            CourseDAO courseDAO = new CourseDAO();
            DisciplineDAO disciplineDAO = new DisciplineDAO();
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result.add(new CourseStructure(courseDAO.get(rs.getInt(1)), disciplineDAO.get(rs.getInt(2)), rs.getInt(3), rs.getBoolean(4)));
                return result;
            } else {
                return null;
            }
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public CourseStructure insert(CourseStructure object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "INSERT INTO CourseStructure VALUES(?, ?, ?, ?);";
            CourseStructure result = null;
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getCourse().getId());
            stmt.setInt(2, object.getDiscipline().getId());
            stmt.setInt(3, object.getSemester());
            stmt.setBoolean(4, object.isFacultative());
            stmt.executeUpdate();
            return object;
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void insertRange(List<CourseStructure> objects) throws Exception {
        for(CourseStructure object : objects) {
            insert(object);
        }
    }

    @Override
    public boolean exists(CourseStructure object) throws Exception {
        return get(object.getCourse(), object.getDiscipline()) != null;
    }

    @Override
    public void delete(CourseStructure object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "DELETE FROM CourseStructure WHERE IdCourse = ? AND IdDiscipline = ?;";
            // SQL Query Execution
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getCourse().getId());
            stmt.setInt(2, object.getDiscipline().getId());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(CourseStructure object) throws Exception {
        Connection conn = ConnectionFactory.openConnection();
        try {
            String sql = "UPDATE FROM CourseStructure SET Semester = ?, Facultative = ? WHERE IdCourse = ? AND IdDiscipline = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(3, object.getCourse().getId());
            stmt.setInt(4, object.getDiscipline().getId());
            stmt.setInt(1, object.getSemester());
            stmt.setBoolean(2, object.isFacultative());
            stmt.executeUpdate();
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }
    
}