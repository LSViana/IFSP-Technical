package enrollmentrenovation.business;

public class City {

    private int Id;
    private String Name;
    private int IdState;

    public City(int Id, String Name, int IdState) {
        this.Id = Id;
        this.Name = Name;
        this.IdState = IdState;
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

    public int getIdState() {
        return IdState;
    }

    public void setIdState(int IdState) {
        this.IdState = IdState;
    }
    
    
}
