package enrollmentrenovation.service;
import java.sql.SQLException;
import java.util.List;
import enrollmentrenovation.business.City;
public interface CityFunctional {
	public City register(int Id, String Name, int IdState) throws ClassNotFoundException, SQLException;
	public List<City> searchAll() throws SQLException, ClassNotFoundException;
	public List<City> filter(String Name) throws SQLException, ClassNotFoundException;
	public void update(int Id, String Name, int IdState) throws ClassNotFoundException, SQLException;
	public void delete(String Name) throws ClassNotFoundException, SQLException;
}