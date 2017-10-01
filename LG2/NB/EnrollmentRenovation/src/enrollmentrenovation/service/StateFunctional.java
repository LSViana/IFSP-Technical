package enrollmentrenovation.service;
import java.sql.SQLException;
import java.util.List;
import enrollmentrenovation.business.State;
public interface StateFunctional {
	public State register(int Id, String Name, String Initials) throws Exception;
	public List<State> searchAll() throws Exception;
	public List<State> filter(String Name) throws Exception;
	public void update(int Id, String Name, String Initials) throws Exception;
	public void delete(String Name) throws Exception;
}