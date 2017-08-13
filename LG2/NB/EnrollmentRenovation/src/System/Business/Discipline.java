package System.Business;
public class Discipline implements EntityModel {
    private int Id;
    private String Name;
    public Discipline(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
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
}