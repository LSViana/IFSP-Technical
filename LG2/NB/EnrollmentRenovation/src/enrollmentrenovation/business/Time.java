package enrollmentrenovation.business;

import java.time.LocalTime;

public class Time {

    private int Id;
    private LocalTime Time;

    public Time(int Id, LocalTime Time) {
        this.Id = Id;
        this.Time = Time;
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
