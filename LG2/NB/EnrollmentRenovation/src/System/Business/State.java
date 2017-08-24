package System.Business;
public class State implements EntityModel {
    private int Id;
    private String Name;
    private String Initials;
    public State(int Id, String Name, String Initials) {
        this.Id = Id;
        this.Name = Name;
        this.Initials = Initials;
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
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getInitials() {
        return Initials;
    }
    public void setInitials(String Initials) {
        this.Initials = Initials;
    }
}