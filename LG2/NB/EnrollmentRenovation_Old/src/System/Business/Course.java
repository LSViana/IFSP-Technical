package System.Business;
import java.lang.reflect.Field;
public class Course extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private String Name;
    private Integer IdSchool;
    public Course(Integer Id, String Name, Integer IdSchool) {
        this.Id = Id;
        this.Name = Name;
        this.IdSchool = IdSchool;
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
    public Integer getIdSchool() {
        return IdSchool;
    }
    public void setIdSchool(Integer IdSchool) {
        this.IdSchool = IdSchool;
    }
}