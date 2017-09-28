package enrollmentrenovation.service;

import enrollmentrenovation.business.State;
import enrollmentrenovation.data.StateDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateService implements StateFunctional {
    private StateDAO dao;

    public StateService() {
        dao = new StateDAO();
    }
    
    @Override
    public State register(int Id, String Name, String Initials) throws Exception {
        State result = new State(Id, Name, Initials);
        try {
            dao.insert(result);
            result.setId(dao.get(result.getName()).getId());
        } catch (Exception ex) {
            Logger.getLogger(StateService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<State> searchAll() throws Exception {
        try {
            return dao.getAll();
        } catch (Exception ex) {
            Logger.getLogger(StateService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<State> filter(String Name) throws Exception {
        try {
            return dao.filter(Name);
        } catch (Exception ex) {
            Logger.getLogger(StateService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(int Id, String Name, String Initials) throws Exception {
        dao.update(Id, Name, Initials);
    }

    @Override
    public void delete(String Name) throws Exception {
        dao.delete(Name);
    }    
}