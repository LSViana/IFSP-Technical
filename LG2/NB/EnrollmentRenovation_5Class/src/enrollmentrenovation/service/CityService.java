package enrollmentrenovation.service;

import enrollmentrenovation.business.City;
import enrollmentrenovation.data.CityDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityService implements CityFunctional {
    
    private CityDAO dao;
    
    public CityService() {
        dao = new CityDAO();
    }

    @Override
    public City register(int Id, String Name, int IdState) throws ClassNotFoundException, SQLException {
        City result = new City(Id, Name, IdState);
        try {
            dao.insert(result);
        } catch (Exception ex) {
            Logger.getLogger(CityService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<City> searchAll() throws SQLException, ClassNotFoundException {
        try {
            return dao.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CityService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<City> filter(String Name) throws SQLException, ClassNotFoundException {
        try {
            return dao.filter(Name);
        } catch (Exception ex) {
            Logger.getLogger(CityService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(int Id, String Name, int IdState) throws ClassNotFoundException, SQLException {
        dao.update(Id, Name, IdState);
    }

    @Override
    public void delete(String Name) throws ClassNotFoundException, SQLException {
        dao.delete(Name);
    }    
}