package enrollmentrenovation.service;
import java.sql.SQLException;
import java.util.List;
import enrollmentrenovation.business.State;
public interface StateFunctional {
	public State register(int Id, String Name, String Initials) throws ClassNotFoundException, SQLException;
	public List<State> searchAll() throws SQLException, ClassNotFoundException;
	public List<State> filter(String Name) throws SQLException, ClassNotFoundException;
	public void update(int Id, String Name, String Initials) throws ClassNotFoundException, SQLException;
	public void delete(String Name) throws ClassNotFoundException, SQLException;
}