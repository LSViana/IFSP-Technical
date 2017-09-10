package System.Business;
import java.lang.reflect.Field;
import java.time.LocalTime;
public class Time extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private LocalTime Time;
    public Time(Integer Id, LocalTime Time) {
        this.Id = Id;
        this.Time = Time;
    }
    @Override
    public Integer[] getIds() {
        return new Integer[] { Id };
    }
    
    public Integer getId() {
        return Id;
    }
    public void setId(Integer Id) {
        this.Id = Id;
    }
    public LocalTime getTime() {
        return Time;
    }
    public void setTime(LocalTime Time) {
        this.Time = Time;
    }
}