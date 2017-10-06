package enrollmentrenovation.data;
import java.util.List;
public interface EntityModel<T> {
	public List<T> getAll() throws Exception;
	public T insert(T object) throws Exception;
	public void insertRange(List<T> objects) throws Exception;
	public boolean exists(T object) throws Exception;
        public void delete(T object) throws Exception;
        public void update(T object) throws Exception;
}