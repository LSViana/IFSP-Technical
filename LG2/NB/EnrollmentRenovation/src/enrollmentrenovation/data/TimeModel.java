package enrollmentrenovation.data;
import enrollmentrenovation.business.Time;
import java.time.LocalTime;
public interface TimeModel extends EntityModel<Time> {
    public Time get(int Id) throws Exception;
    public Time get(LocalTime Time) throws Exception;
}
