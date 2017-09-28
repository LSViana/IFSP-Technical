package enrollmentrenovation.service;
import java.sql.SQLException;
import java.util.List;
import enrollmentrenovation.business.Time;
import java.time.LocalTime;
public interface TimeFunctional {
	public Time register(int Id, LocalTime Time) throws ClassNotFoundException, SQLException;
	public List<Time> searchAll() throws ClassNotFoundException, SQLException;
	public void delete(LocalTime Time) throws ClassNotFoundException, SQLException;
        public void update(int id, LocalTime time) throws ClassNotFoundException, SQLException;
}