package enrollmentrenovation.service;

import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.data.DisciplineDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplineService implements DisciplineFunctional {
    private DisciplineDAO dao;
    
    public DisciplineService() {
        dao = new DisciplineDAO();
    }
    
    @Override
    public Discipline register(int Id, String Name) throws ClassNotFoundException, SQLException {
        Discipline result = new Discipline(Id, Name);
        try {
            dao.insert(result);
            result.setId(dao.get(result.getName()).getId());
        } catch (Exception ex) {
            Logger.getLogger(DisciplineService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Discipline> searchAll() throws SQLException, ClassNotFoundException {
        try {
            return dao.getAll();
        } catch (Exception ex) {
            Logger.getLogger(DisciplineService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Discipline> filter(String Name) throws SQLException, ClassNotFoundException {
        try {
            return dao.filter(Name);
        } catch (Exception ex) {
            Logger.getLogger(DisciplineService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(int Id, String Name) throws ClassNotFoundException, SQLException {
        dao.update(Id, Name);
    }

    @Override
    public void delete(String Name) throws ClassNotFoundException, SQLException {
        dao.delete(Name);
    }    
}