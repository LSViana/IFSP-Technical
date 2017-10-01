package System.Business;
import java.lang.reflect.Field;
public class City extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private String Name;
    private Integer IdState;
    public City(Integer Id, String Name, Integer IdState) {
        this.Id = Id;
        this.Name = Name;
        this.IdState = IdState;
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
    public Integer getIdState() {
        return IdState;
    }
    public void setIdState(Integer IdState) {
        this.IdState = IdState;
    }
}