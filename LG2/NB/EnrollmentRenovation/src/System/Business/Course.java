package System.Business;
public class Course implements EntityModel {
    private int Id;
    private String Name;
    private int IdSchool;
    public Course(int Id, String Name, int IdSchool) {
        this.Id = Id;
        this.Name = Name;
        this.IdSchool = IdSchool;
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
    public int getIdSchool() {
        return IdSchool;
    }
    public void setIdSchool(int IdSchool) {
        this.IdSchool = IdSchool;
    }
}