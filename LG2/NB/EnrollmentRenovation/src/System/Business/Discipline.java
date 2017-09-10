package System.Business;
import java.lang.reflect.Field;
public class Discipline extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private String Name;
    public Discipline(Integer Id, String Name) {
        this.Id = Id;
        this.Name = Name;
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
}