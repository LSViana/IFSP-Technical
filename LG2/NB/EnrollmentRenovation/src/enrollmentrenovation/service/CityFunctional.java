package enrollmentrenovation.service;
import java.util.List;
import enrollmentrenovation.business.City;
public interface CityFunctional {
	public City register(int Id, String Name, int IdState) throws Exception;
	public List<City> searchAll() throws Exception;
	public List<City> filter(String Name) throws Exception;
	public void update(int Id, String Name, int IdState) throws Exception;
	public void delete(String Name) throws Exception;
}