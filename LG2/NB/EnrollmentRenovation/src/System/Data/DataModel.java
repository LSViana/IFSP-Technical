package System.Data;
import System.Business.EntityModel;
import java.util.List;
public interface DataModel<T extends EntityModel> {
    public List<T> getAll();
    public T get(int index);
    public T get(String key);
    public List<T> filter(String filter);
    public boolean insert(T item);
    public boolean insertRange(List<T> items);
    public boolean exists(String key);
}