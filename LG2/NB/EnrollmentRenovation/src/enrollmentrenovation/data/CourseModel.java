package enrollmentrenovation.data;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.School;
import java.util.List;
public interface CourseModel extends EntityModel<Course> {
<<<<<<< HEAD
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
=======
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
>>>>>>> 37b16e240b9b74119f42a1fb17b8da50f7da7ef5
}
