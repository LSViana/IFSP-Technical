package enrollmentrenovation.data;
import enrollmentrenovation.business.State;
public interface StateModel extends EntityModel<State> {
    public void update(int id, String name, String initials) throws Exception;
}
