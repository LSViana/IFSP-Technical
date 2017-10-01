package System.Business;
import java.lang.reflect.Field;
public abstract class EntityModel {
    protected static String ClassName;
    protected static Field[] Fields;
    public static String getClassName() {
        return ClassName;
    }
    public static Field[] getFields() {
        return Fields;
    }
    public abstract Integer[] getIds();
}