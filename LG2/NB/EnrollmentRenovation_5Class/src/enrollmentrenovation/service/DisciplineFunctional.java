package enrollmentrenovation.service;
import java.sql.SQLException;
import java.util.List;
import enrollmentrenovation.business.Discipline;
public interface DisciplineFunctional {
	public Discipline register(int Id, String Name) throws ClassNotFoundException, SQLException;
	public List<Discipline> searchAll() throws SQLException, ClassNotFoundException;
	public List<Discipline> filter(String Name) throws SQLException, ClassNotFoundException;
	public void update(int Id, String Name) throws ClassNotFoundException, SQLException;
	public void delete(String Name) throws ClassNotFoundException, SQLException;
}