package enrollmentrenovation.data;
import enrollmentrenovation.business.State;
import enrollmentrenovation.business.School;
import enrollmentrenovation.business.User;
import java.util.List;
public interface StateModel extends EntityModel<State> {
    public State get(int Id) throws Exception;
    public State get(String Name) throws Exception;
    // Relationships
    public List<School> getSchools(State state) throws Exception;
    public List<User> getUsers(State state) throws Exception;
}
