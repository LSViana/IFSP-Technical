package enrollmentrenovation.data;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.School;
import java.util.List;
public interface CourseModel extends EntityModel<Course> {
    public Course get(int Id);
    public Course get(String Name);
    // Relationships
    public School getSchool(Course course);
    public List<Credits> getCredits(Course course);
    public List<CourseStructure> getStructures(Course course);
    public List<Enrollment> getEnrollments(Course course);   
    // Operations
    public void insertStructure(CourseStructure courseStructure);
    public void deleteStructure(CourseStructure courseStructure);
    public CourseStructure containsDiscipline(Course course, Discipline discipline);    
}
