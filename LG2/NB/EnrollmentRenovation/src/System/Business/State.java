package System.Business;
import java.lang.reflect.Field;
public class State extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private String Name;
    private String Initials;
    public State(Integer Id, String Name, String Initials) {
        this.Id = Id;
        this.Name = Name;
        this.Initials = Initials;
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