package enrollmentrenovation.data;
import java.util.List;
import enrollmentrenovation.business.*;
public interface EntityModel<T> {
	public List<T> getAll() throws Exception;
	public T get(int index) throws Exception;
	public T get(String filter) throws Exception;
	public List<T> filter(String filter) throws Exception;
	public boolean insert(T object) throws Exception;
	public boolean insertRange(List<T> objects) throws Exception;
	public boolean exists(String filter) throws Exception;
        public void delete(String filter) throws Exception;
}