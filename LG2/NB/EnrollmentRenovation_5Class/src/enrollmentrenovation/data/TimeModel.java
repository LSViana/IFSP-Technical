package enrollmentrenovation.data;

import java.sql.SQLException;
import java.time.LocalTime;
import enrollmentrenovation.business.Time;

public interface TimeModel extends EntityModel<Time> {
    public void delete(LocalTime time) throws Exception;
    public void update(int id, LocalTime time) throws Exception;
}
