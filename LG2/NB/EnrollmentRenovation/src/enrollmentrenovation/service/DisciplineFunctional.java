package enrollmentrenovation.service;
import java.util.List;
import enrollmentrenovation.business.Discipline;
public interface DisciplineFunctional {
	public Discipline register(int Id, String Name) throws Exception;
	public List<Discipline> searchAll() throws Exception;
	public List<Discipline> filter(String Name) throws Exception;
	public void update(int Id, String Name) throws Exception;
	public void delete(String Name) throws Exception;
}