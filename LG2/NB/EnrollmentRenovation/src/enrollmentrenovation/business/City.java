package enrollmentrenovation.business;

public class City {

    private int Id;
    private String Name;
    private State State;

    public City(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public State getState() {
        return State;
    }

    public void setState(State State) {
        this.State = State;
    }

    
}
