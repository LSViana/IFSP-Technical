package enrollmentrenovation.data;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.School;
import java.util.List;
public interface CourseModel extends EntityModel<Course> {
    public Course get(int Id) throws Exception;
    public Course get(String Name) throws Exception;
    // Relationships
    public School getSchool(Course course) throws Exception;
    public List<Credits> getCredits(Course course) throws Exception;
    public List<CourseStructure> getStructures(Course course) throws Exception;
    public List<Enrollment> getEnrollments(Course course) throws Exception;   
    // Operations
    public void insertStructure(Course course, CourseStructure courseStructure) throws Exception;
    public void deleteStructure(Course course, CourseStructure courseStructure) throws Exception;
    public CourseStructure containsDiscipline(Course course, Discipline discipline) throws Exception;    
}
