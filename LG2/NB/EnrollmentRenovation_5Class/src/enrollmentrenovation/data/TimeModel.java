package enrollmentrenovation.data;

import java.sql.SQLException;
import java.time.LocalTime;

public interface TimeModel {
    public void delete(LocalTime time) throws Exception;
    public void update(int id, LocalTime time) throws ClassNotFoundException, SQLException;
}
