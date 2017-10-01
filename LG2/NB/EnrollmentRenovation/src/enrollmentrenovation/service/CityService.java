package enrollmentrenovation.service;

import enrollmentrenovation.business.City;
import enrollmentrenovation.data.CityModel;
import enrollmentrenovation.data.CityDAO;
import java.util.List;

public class CityService implements CityFunctional {

    private CityModel dao;

    public CityService() {
        dao = new CityDAO();
    }

    @Override
    public City register(int Id, String Name, int IdState) throws Exception {
        City result = new City(Id, Name, IdState);
        dao.insert(result);
        result.setId(dao.get(Name).getId());
        return result;
    }

    @Override
    public List<City> searchAll() throws Exception {
        return dao.getAll();
    }

    @Override
    public List<City> filter(String Name) throws Exception {
        return dao.filter(Name);
    }

    @Override
    public void update(int Id, String Name, int IdState) throws Exception {
        dao.update(Id, Name, IdState);
    }

    @Override
    public void delete(String Name) throws Exception {
        dao.delete(Name);
    }
}
