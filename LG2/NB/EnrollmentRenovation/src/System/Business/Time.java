package System.Business;
import java.time.LocalTime;
public class Time implements EntityModel {
    private int Id;
    private LocalTime Time;
    public Time(int Id, LocalTime Time) {
        this.Id = Id;
        this.Time = Time;
    }
    @Override
    public int[] getIds() {
        return new int[] { Id };
    }
    
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public LocalTime getTime() {
        return Time;
    }
    public void setTime(LocalTime Time) {
        this.Time = Time;
    }
}