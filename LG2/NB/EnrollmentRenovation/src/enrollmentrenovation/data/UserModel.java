package enrollmentrenovation.data;
import enrollmentrenovation.business.User;
import enrollmentrenovation.business.State;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Enrollment;
import java.util.List;
public interface UserModel extends EntityModel<User> {
    public User get(int Id) throws Exception;
    /**
     * This method will be a generic one to perform login operations, while I'm writing this code, the login is performed through "Id" and "Password"
     * @param Username Id of the User
     * @param Password Password of the User
     * @return The User object from the database or Null, if no User is found
     */
    public User get(String Username, String Password) throws Exception;
    // Relationships
    public State getState(User user) throws Exception;
    public List<Credits> getCredits(User user) throws Exception;
    public List<Enrollment> getEnrollments(User user) throws Exception;
}
