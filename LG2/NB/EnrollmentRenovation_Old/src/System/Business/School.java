package System.Business;
import java.lang.reflect.Field;
public class School extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private Integer IdCity;
    public School(Integer Id, Integer IdCity) {
        this.Id = Id;
        this.IdCity = IdCity;
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
    public Integer getIdCity() {
        return IdCity;
    }
    public void setIdCity(Integer IdCity) {
        this.IdCity = IdCity;
    }
}