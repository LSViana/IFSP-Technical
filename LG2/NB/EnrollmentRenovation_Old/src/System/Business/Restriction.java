package System.Business;
import java.lang.reflect.Field;
public class Restriction extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer IdRequired;
    private Integer IdProvided;
    public Restriction(Integer IdRequired, Integer IdProvided) {
        this.IdRequired = IdRequired;
        this.IdProvided = IdProvided;
    }
    public Integer getIdRequired() {
        return IdRequired;
    }
    public void setIdRequired(Integer IdRequired) {
        this.IdRequired = IdRequired;
    }
    public Integer getIdProvided() {
        return IdProvided;
    }
    public void setIdProvided(Integer IdProvided) {
        this.IdProvided = IdProvided;
    }

    @Override
    public Integer[] getIds() {
        return new Integer[] { IdRequired, IdProvided };
    }
}
