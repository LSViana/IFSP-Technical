package enrollmentrenovation.data;
import enrollmentrenovation.business.School;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.State;
import java.util.List;
public interface SchoolModel extends EntityModel<School> {
    public School get(int Id) throws Exception;
    public School get(String Name) throws Exception;
    // Relationships
    public List<Course> getCourses(School school) throws Exception;
    public State getState(School school) throws Exception;
}
