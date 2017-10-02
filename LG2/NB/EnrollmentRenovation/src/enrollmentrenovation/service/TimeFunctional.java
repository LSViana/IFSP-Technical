package enrollmentrenovation.service;
import java.sql.SQLException;
import java.util.List;
import enrollmentrenovation.business.Time;
import java.time.LocalTime;
public interface TimeFunctional {
	public Time register(int Id, LocalTime Time) throws Exception;
	public List<Time> searchAll() throws Exception;
	public void delete(LocalTime Time) throws Exception;
        public void update(int id, LocalTime time) throws Exception;
}