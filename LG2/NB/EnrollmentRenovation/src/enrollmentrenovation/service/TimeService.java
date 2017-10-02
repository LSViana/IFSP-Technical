package enrollmentrenovation.service;

import enrollmentrenovation.business.Time;
import enrollmentrenovation.data.TimeDAO;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeService implements TimeFunctional {
    private TimeDAO dao;

    public TimeService() {
        this.dao = new TimeDAO();
    }
    
    @Override
    public Time register(int Id, LocalTime Time) throws Exception {
        Time result = new Time(Id, Time);
        try {
            dao.insert(result);
            result.setId(dao.get(result.getTime().toString()).getId());
        } catch (Exception ex) {
            Logger.getLogger(TimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Time> searchAll() throws Exception {
        try {
            return dao.getAll();
        } catch (Exception ex) {
            Logger.getLogger(TimeService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void delete(LocalTime time) throws Exception {
        try {
            dao.delete(time);
        } catch (Exception ex) {
            Logger.getLogger(TimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int id, LocalTime time) throws Exception {
        dao.update(id, time);
    }
}